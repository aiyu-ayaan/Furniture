package com.aiyu.furniture.ui.fragment.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.model.FurnitureModel;
import com.aiyu.furniture.databinding.ItemFurnitureBinding;
import com.aiyu.furniture.utils.Images;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class RecyclerViewAdapter extends ListAdapter<FurnitureModel, RecyclerViewAdapter.ItemViewHolder> {

    public interface SetOnClickListener {
        void onClick(FurnitureModel furnitureModel);
    }

    private SetOnClickListener onClickListener;

    public void setItemOnClickListener(SetOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    protected RecyclerViewAdapter() {
        super(new DiffUtil.ItemCallback<>() {
            @Override
            public boolean areItemsTheSame(@NonNull FurnitureModel oldItem, @NonNull FurnitureModel newItem) {
                return oldItem.getPath().equals(newItem.getPath());
            }

            @Override
            public boolean areContentsTheSame(@NonNull FurnitureModel oldItem, @NonNull FurnitureModel newItem) {
                return oldItem.getPath().equals(newItem.getPath());
            }
        });
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemFurnitureBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        FurnitureModel furnitureModel = getItem(position);
        holder.bindData(furnitureModel);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemFurnitureBinding binding;

        public ItemViewHolder(ItemFurnitureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(FurnitureModel furnitureModel) {
            binding.textViewProductName.setText(furnitureModel.getName());
            binding.textViewPrice.setText("₹ " + furnitureModel.getPrice());
            binding.textViewRating.setText(String.valueOf(furnitureModel.getStar()));

            var image = Images.getRandomImage();
            Images.extractDominantColor(
                    binding.getRoot().getContext(), image, binding.cardViewProductImage);
            furnitureModel.setImageRes(image);
            Glide.with(binding.getRoot()).load(image)
                    .fitCenter().error(R.drawable.login_screen_img)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.imageViewProduct);
            binding.getRoot().setOnClickListener(v -> {
                if (onClickListener != null) onClickListener.onClick(furnitureModel);
            });
        }
    }
}
