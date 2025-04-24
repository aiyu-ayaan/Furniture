package com.aiyu.furniture.ui.fragment.orders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.model.OrderModel;
import com.aiyu.furniture.databinding.ItemOrderBinding;
import com.aiyu.furniture.utils.Images;
import com.bumptech.glide.Glide;

public class OrderAdapter extends ListAdapter<OrderModel, OrderAdapter.OrderViewHolder> {

    public interface SetOnClickListener {
        void onItemClick(OrderModel orderModel);
    }

    private SetOnClickListener setOnClickListener;

    public void setOnClickListener(SetOnClickListener setOnClickListener) {
        this.setOnClickListener = setOnClickListener;
    }

    protected OrderAdapter() {
        super(new DiffUtil.ItemCallback<OrderModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull OrderModel oldItem, @NonNull OrderModel newItem) {
                return oldItem.getPath().equals(newItem.getPath());
            }

            @Override
            public boolean areContentsTheSame(@NonNull OrderModel oldItem, @NonNull OrderModel newItem) {
                return oldItem.getPath().equals(newItem.getPath());
            }
        });
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(
                ItemOrderBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderModel orderDetails = getItem(position);
        holder.bind(orderDetails);

    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        private final ItemOrderBinding binding;

        public OrderViewHolder(
                ItemOrderBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(OrderModel orderDetails) {
            binding.textViewProductName.setText(orderDetails.getFurniture().getName());
            binding.textViewProductDescription.setText(orderDetails.getFurniture().getDescription());
            binding.textViewPrice.setText("₹ " + orderDetails.getFurniture().getPrice());
            Glide.with(binding.getRoot())
                    .load(Images.getRandomImage())
                    .centerCrop()
                    .into(binding.imageViewProduct);

            binding.getRoot().setOnClickListener(
                    view -> {
                        if (setOnClickListener != null) {
                            setOnClickListener.onItemClick(orderDetails);
                        }
                    }
            );
        }
    }
}
