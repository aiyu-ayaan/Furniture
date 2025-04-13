package com.aiyu.furniture.ui.fragment.cart;

import static android.view.View.GONE;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.core.database.model.CartModel;
import com.aiyu.furniture.databinding.FragmentCartBinding;
import com.aiyu.furniture.utils.BaseFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CartFragment extends BaseFragment {

    private FragmentCartBinding binding;
    @Inject
    FirebaseInteraction interaction;

    public CartFragment() {
        super(R.layout.fragment_cart);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentCartBinding.bind(view);
        var adapter = new CartAdapter();
        binding.recyclerViewCart.setAdapter(adapter);
        binding.recyclerViewCart.setLayoutManager(new LinearLayoutManager(getContext()));
        interaction.getCartItems((cartModels, e) -> {
            if (e != null) {
                binding.linearLayoutLoading.setVisibility(GONE);
                binding.recyclerViewCart.setVisibility(GONE);
                binding.linearLayoutEmptyCart.setVisibility(View.VISIBLE);
                return;
            }
            if (cartModels == null || cartModels.isEmpty()) {
                binding.linearLayoutLoading.setVisibility(GONE);
                binding.recyclerViewCart.setVisibility(GONE);
                binding.linearLayoutEmptyCart.setVisibility(View.VISIBLE);
            } else {
                binding.linearLayoutLoading.setVisibility(GONE);
                binding.recyclerViewCart.setVisibility(View.VISIBLE);
                binding.linearLayoutEmptyCart.setVisibility(GONE);
                adapter.submitList(cartModels);
            }
        });
        adapter.setCartClickListener(new CartAdapter.CartClickListener() {
            @Override
            public void onItemClick(CartModel cartModel) {
                Navigation.findNavController(binding.getRoot())
                        .navigate(
                                CartFragmentDirections
                                        .actionCartFragmentToDetailFragment(
                                                cartModel.getItems(),
                                                true
                                        )
                        );
            }

            @Override
            public void onItemRemove(CartModel cartModel) {
                interaction.removeItemFromCart(cartModel.getItems().getPath(), e -> {
                    if (e != null) {
                        Toast.makeText(requireContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(requireContext(), "Removed from cart", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}
