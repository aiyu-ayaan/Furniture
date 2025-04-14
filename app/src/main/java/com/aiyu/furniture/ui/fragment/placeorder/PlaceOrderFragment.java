package com.aiyu.furniture.ui.fragment.placeorder;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentPlaceOrderBinding;
import com.aiyu.furniture.utils.BaseFragment;

public class PlaceOrderFragment extends BaseFragment {
    private FragmentPlaceOrderBinding binding;
    public PlaceOrderFragment() {
        super(R.layout.fragment_order_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPlaceOrderBinding.bind(view);
    }
}
