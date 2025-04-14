package com.aiyu.furniture.ui.fragment.orders;

import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.databinding.FragmentOrdersBinding;
import com.aiyu.furniture.utils.BaseFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OrdersFragment extends BaseFragment {

    private FragmentOrdersBinding binding;

    @Inject
    FirebaseInteraction interaction;

    public OrdersFragment() {
        super(R.layout.fragment_orders);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentOrdersBinding.bind(view);
        var adapter = new OrderAdapter();
        binding.recyclerViewOrders.setAdapter(adapter);
        binding.recyclerViewOrders.setHasFixedSize(true);
        binding.recyclerViewOrders.setLayoutManager(new LinearLayoutManager(requireContext()));
        interaction.getOrders((orderModels, e) -> {
            if (e != null) {
                binding.linearLayoutLoading.setVisibility(View.GONE);
                binding.linearLayoutEmptyOrder.setVisibility(VISIBLE);
                return;
            }
            binding.linearLayoutLoading.setVisibility(View.GONE);
            binding.linearLayoutEmptyOrder.setVisibility(View.GONE);
            binding.recyclerViewOrders.setVisibility(VISIBLE);
            adapter.submitList(orderModels);
        });
        adapter.setOnClickListener(orderModel -> {
            Navigation.findNavController(view)
                    .navigate(OrdersFragmentDirections.actionOrdersFragmentToOrderDetailsFragment(orderModel));
        });
    }
}
