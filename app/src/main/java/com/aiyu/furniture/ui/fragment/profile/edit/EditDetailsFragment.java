package com.aiyu.furniture.ui.fragment.profile.edit;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.databinding.FragmentEditDetailsBinding;
import com.aiyu.furniture.utils.BaseFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EditDetailsFragment extends BaseFragment {
    private FragmentEditDetailsBinding binding;

    public EditDetailsFragment() {
        super(R.layout.fragment_edit_details);
    }

    @Inject
    FirebaseInteraction interaction;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentEditDetailsBinding.bind(view);
        EditDetailsFragmentArgs args = EditDetailsFragmentArgs.fromBundle(getArguments());
        var user = args.getUser();
        binding.phoneLayout.getEditText().setText((user.getPhone() == null || user.getPhone().isBlank()) ? "" : user.getPhone());

        binding.buttonSave.setOnClickListener(v -> {
            var phone = binding.phoneLayout.getEditText().getText().toString();
            if (phone.isEmpty()) {
                Toast.makeText(requireContext(), "Can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            user.setPhone(
                    phone
            );
            interaction.updateUser(user, (exception) -> {
                if (exception != null) {
                    Toast.makeText(requireContext(), exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(binding.getRoot())
                        .navigateUp();
            });
        });
    }
}
