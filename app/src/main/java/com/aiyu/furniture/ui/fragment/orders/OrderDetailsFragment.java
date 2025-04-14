package com.aiyu.furniture.ui.fragment.orders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentOrderDetailsBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderDetailsFragment extends BaseFragment {
    private FragmentOrderDetailsBinding binding;
    private OrderDetailsFragmentArgs args;

    public OrderDetailsFragment() {
        super(R.layout.fragment_order_details);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentOrderDetailsBinding.bind(view);
        args = OrderDetailsFragmentArgs.fromBundle(getArguments());
        var orderDetails = args.getOrder();
        binding.textViewProductName.setText(orderDetails.getFurniture().getName());
        binding.textViewProductDescription.setText(orderDetails.getFurniture().getDescription());
        binding.textViewPrice.setText("₹ " + orderDetails.getFurniture().getPrice());
        binding.textViewCategory.setText(orderDetails.getFurniture().getCategory().name());
        binding.textViewOrderStatus.setText(orderDetails.getOrderState().name());
        binding.textViewOrderDate.setText(getDate(orderDetails.getOrderedAt()));

        binding.textViewRecipientName.setText(orderDetails.getAddress().getName());
        binding.textViewPhone.setText(orderDetails.getAddress().getPhone());
        binding.textViewHouseArea.setText(orderDetails.getAddress().getHouseName() + " " + orderDetails.getAddress().getArea());
        binding.textViewLandmark.setText(orderDetails.getAddress().getLandmark());
        binding.textViewStatePostal.setText(orderDetails.getAddress().getState() + ", " + String.valueOf(orderDetails.getAddress().getPostalCode()));

        binding.textViewItemPrice.setText("₹ " + orderDetails.getPrice());
        binding.textViewDeliveryFee.setText("₹ " + 50);

        binding.textViewTotal.setText("₹ " + (orderDetails.getPrice() + 50));
        Glide.with(binding.getRoot())
                .load(R.drawable.login_screen_img)
                .centerCrop()
                .into(binding.imageViewProduct);
    }


    private String getDate(Long date) {
        if (date == null) return "";
        var dateFormat = new SimpleDateFormat("MMM dd,yyyy", Locale.getDefault());
        return dateFormat.format(new Date(date));
    }
}
