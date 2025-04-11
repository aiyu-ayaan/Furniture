package com.aiyu.furniture.ui.fragment.detail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentDetailScreenBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends BaseFragment {
    public DetailFragment() {
        super(R.layout.fragment_detail_screen);
    }

    private FragmentDetailScreenBinding binding;
    private DetailFragmentArgs args;
    private int quantity = 1;

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
        Glide.with(binding.getRoot())
                .load(R.drawable.login_screen_img)
                .fitCenter().error(R.drawable.login_screen_img)
                .transition(DrawableTransitionOptions.withCrossFade()).into(binding.imageViewProduct);


    }
}
