package com.aiyu.furniture.ui.fragment.address;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.core.database.interaction.FirebaseInteractionNoDataFoundException;
import com.aiyu.furniture.core.database.model.AddressModel;
import com.aiyu.furniture.databinding.FragmentAddressBinding;
import com.aiyu.furniture.utils.BaseFragment;

import java.util.List;
import java.util.function.BiConsumer;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddressFragment extends BaseFragment {
    private FragmentAddressBinding binding;

    public AddressFragment() {
        super(R.layout.fragment_address);
    }

    @Inject
    FirebaseInteraction firebaseInteraction;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAddressBinding.bind(view);
        var adapter = new AddressAdapter();
        binding.recyclerViewAddress.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewAddress.setAdapter(adapter);
        binding.recyclerViewAddress.setHasFixedSize(true);
        firebaseInteraction.getAddress(new BiConsumer<>() {
            @Override
            public void accept(List<AddressModel> addressModels, Exception e) {
                if (e != null) {
                    binding.recyclerViewAddress.setVisibility(View.GONE);
                    binding.linearLayoutLoading.setVisibility(View.GONE);
                    binding.linearLayoutEmptyAddress.setVisibility(View.VISIBLE);
                    if (e instanceof FirebaseInteractionNoDataFoundException) {
                        binding.textViewMessage.setText("No address found");
                        return;
                    }
                    binding.textViewMessage.setText("Unable to fetch address");
                    return;
                }
                binding.recyclerViewAddress.setVisibility(View.VISIBLE);
                binding.linearLayoutLoading.setVisibility(View.GONE);
                binding.linearLayoutEmptyAddress.setVisibility(View.GONE);
                adapter.submitList(addressModels);
            }
        });
    }
}
