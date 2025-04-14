package com.aiyu.furniture.ui.fragment.placeorder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentPlaceOrderBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.bumptech.glide.Glide;

public class PlaceOrderFragment extends BaseFragment {
    private FragmentPlaceOrderBinding binding;
    private PlaceOrderFragmentArgs args;

    public PlaceOrderFragment() {
        super(R.layout.fragment_order_details);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPlaceOrderBinding.bind(view);
        args = PlaceOrderFragmentArgs.fromBundle(getArguments());
        var order = args.getOrder();
        binding.textViewOrderId.setText("OD" + order.getOrderedAt());
        binding.textViewProductName.setText(order.getFurniture().getName());
        binding.textViewProductPrice.setText("₹ " + order.getFurniture().getPrice());
        Glide.with(requireActivity()).load(R.drawable.login_screen_img).centerCrop().into(binding.imageViewProductThumbnail);

        binding.textViewItemTotal.setText("₹ " + order.getPrice());
        binding.textViewDeliveryFee.setText("₹ " + 50);
        binding.textViewGrandTotal.setText("₹ " + (order.getPrice() + 50));

        binding.textViewShippingAddress.setText(order.getAddress().getName() + "\n" + order.getAddress().getArea() + "\n" + order.getAddress().getHouseName() + ", " + order.getAddress().getArea() + " " + order.getAddress().getLandmark() + "\n" + order.getAddress().getPostalCode() + "\n" + order.getAddress().getState() + "\n");

        binding.buttonTrackOrder.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(
                    PlaceOrderFragmentDirections.actionPlaceOrderFragmentToHomeFragment()
            );
        });
        binding.buttonContinueShopping.setOnClickListener(view2 -> {
            Navigation.findNavController(view).navigate(
                    PlaceOrderFragmentDirections.actionPlaceOrderFragmentToOrderDetailsFragment(order)
            );
        });
    }
}
