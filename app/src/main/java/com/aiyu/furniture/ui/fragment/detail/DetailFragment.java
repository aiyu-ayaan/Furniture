package com.aiyu.furniture.ui.fragment.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.aiyu.furniture.NavControllerDirections;
import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.interaction.FirebaseInteraction;
import com.aiyu.furniture.core.database.model.CartModel;
import com.aiyu.furniture.core.database.model.OrderModel;
import com.aiyu.furniture.databinding.FragmentDetailScreenBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.aiyu.furniture.utils.Images;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends BaseFragment {
    public DetailFragment() {
        super(R.layout.fragment_detail_screen);
    }

    private FragmentDetailScreenBinding binding;
    private DetailFragmentArgs args;
    private int quantity = 1;

    @Inject
    FirebaseInteraction firebaseInteraction;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDetailScreenBinding.bind(view);
        args = DetailFragmentArgs.fromBundle(getArguments());
        var model = args.getItem();
        binding.textViewProductName.setText(model.getName());
        binding.textViewDescription.setText(model.getDescription());
        binding.textViewPrice.setText("₹ " + model.getPrice());
        binding.textViewTotal.setText("₹ " + (quantity * model.getPrice()));
        binding.iconButtonAdd.setOnClickListener(view1 -> {
            if (quantity < 10) {
                quantity++;
                binding.textViewQuantity.setText(String.valueOf(quantity));
                binding.textViewTotal.setText("₹ " + (quantity * model.getPrice()));
            }
        });
        binding.iconButtonRemove.setOnClickListener(view1 -> {
            if (quantity > 1) {
                quantity--;
                binding.textViewQuantity.setText(String.valueOf(quantity));
            }
        });
        Glide.with(binding.getRoot()).load(
                        model.getImageRes()
                ).fitCenter()
                .error(R.drawable.login_screen_img).transition(DrawableTransitionOptions.withCrossFade()).into(binding.imageViewProduct);

        Images.extractDominantColor(
                binding.getRoot().getContext(), model.getImageRes(), binding.cardViewBack);

        binding.buttonAddToCart.setVisibility(args.getFromCart() ? View.GONE : View.VISIBLE);
        binding.buttonAddToCart.setOnClickListener(view1 -> {
            firebaseInteraction.addItemToCart(new CartModel(model, quantity), e -> {
                if (e == null) {
                    binding.buttonAddToCart.setEnabled(true);
                    Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(binding.getRoot()).navigateUp();
                    return;
                }
                Toast.makeText(getContext(), Objects.requireNonNull(e.getLocalizedMessage()), Toast.LENGTH_SHORT).show();
            });
        });
        binding.buttonBuyNow.setOnClickListener(view2 -> {
            Navigation.findNavController(view)
                    .navigate(NavControllerDirections.actionGlobalAddressFragment(
                            true,
                            new OrderModel(
                                    model,
                                    model.getPrice() * quantity,
                                    null,
                                    System.currentTimeMillis(),
                                    ""
                            ),
                            args.getFromCart()
                    ));
        });
    }
}
