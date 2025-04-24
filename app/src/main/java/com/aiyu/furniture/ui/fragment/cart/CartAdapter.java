package com.aiyu.furniture.ui.fragment.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aiyu.furniture.core.database.model.CartModel;
import com.aiyu.furniture.databinding.ItemCartBinding;
import com.aiyu.furniture.utils.Images;
import com.bumptech.glide.Glide;

public class CartAdapter extends ListAdapter<CartModel, CartAdapter.CartViewHolder> {

    public CartAdapter() {
        super(new DiffUtil.ItemCallback<CartModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull CartModel oldItem, @NonNull CartModel newItem) {
                return oldItem.getItems().getPath() == newItem.getItems().getPath();
            }

            @Override
            public boolean areContentsTheSame(@NonNull CartModel oldItem, @NonNull CartModel newItem) {
                return oldItem.getItems().getName().equals(newItem.getItems().getName()) &&
                        oldItem.getQuantity() == newItem.getQuantity();
            }
        });
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding itemCartBinding = ItemCartBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(itemCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartModel cartModel = getItem(position);
        holder.bind(cartModel);
    }

    public interface CartClickListener {
        void onItemClick(CartModel cartModel);

        void onItemRemove(CartModel cartModel);
    }

    private CartClickListener cartClickListener;

    public void setCartClickListener(CartClickListener cartClickListener) {
        this.cartClickListener = cartClickListener;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private ItemCartBinding binding;

        public CartViewHolder(
                ItemCartBinding itemCartBinding) {
            super(itemCartBinding.getRoot());
            binding = itemCartBinding;
        }

        public void bind(CartModel cartModel) {
            binding.textViewQuantity.setText(String.valueOf(cartModel.getQuantity()));
            binding.textViewCartPrice.setText("₹ " + (cartModel.getItems().getPrice() * cartModel.getQuantity()));
            binding.textViewCartProductName.setText(cartModel.getItems().getName());
            binding.buttonRemoveItem.setOnClickListener(view -> {
                if (cartClickListener != null) {
                    cartClickListener.onItemRemove(cartModel);
                }
            });

            Glide.with(binding.getRoot())
                    .load(Images.getRandomImage())
                    .centerCrop()
                    .into(binding.imageViewCartProduct);
            binding.getRoot().setOnClickListener(view -> {
                if (cartClickListener != null) {
                    cartClickListener.onItemClick(cartModel);
                }
            });
        }
    }
}
