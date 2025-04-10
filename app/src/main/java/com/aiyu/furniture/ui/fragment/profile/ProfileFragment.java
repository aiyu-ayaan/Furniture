package com.aiyu.furniture.ui.fragment.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentProfileBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.bumptech.glide.Glide;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileFragment extends BaseFragment {
    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    private FragmentProfileBinding binding;
    private ProfileViewModel profileViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentProfileBinding.bind(view);
        profileViewModel.getUser((user, exception) -> {
            if (exception != null) {
                Toast.makeText(requireContext(), exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
            if (user != null) {
                binding.relativeLayoutProfile.setVisibility(View.VISIBLE);
                binding.linearLayoutLoading.setVisibility(View.GONE);
                Glide.with(requireContext()).load(user.getProfilePic()).into(binding.imageViewProfile);
                binding.profileName.setText(user.getName());
                binding.profileEmail.setText(user.getEmail());
                binding.phoneLayout.getEditText().setText((user.getPhone() == null || user.getPhone().isBlank()) ? "Not Provided" : user.getPhone());
                binding.addressLayout.getEditText().setText((user.getAddress() == null || user.getAddress().isBlank()) ? "Not Provided" : user.getAddress());
                binding.phoneLayout.setEndIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(requireContext(), "Click", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.logoutButton.setOnClickListener(v -> {
            profileViewModel.logOut(unused -> {
                Navigation.findNavController(binding.getRoot()).navigate(ProfileFragmentDirections.actionProfileFragmentToLogInFragment());
            });
        });
    }
}
