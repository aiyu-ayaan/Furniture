package com.aiyu.furniture.ui.fragment.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aiyu.furniture.core.database.model.Furniture;
import com.aiyu.furniture.databinding.ItemFurnitureBinding;

public class RecyclerViewAdapter extends ListAdapter<Furniture, RecyclerViewAdapter.ItemViewHolder> {

    protected RecyclerViewAdapter() {
        super(new DiffUtil.ItemCallback<Furniture>() {
            @Override
            public boolean areItemsTheSame(@NonNull Furniture oldItem, @NonNull Furniture newItem) {
                return oldItem.getPath().equals(newItem.getPath());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Furniture oldItem, @NonNull Furniture newItem) {
                return
                        oldItem.getDescription().equals(newItem.getDescription()) &&
                                oldItem.getImageUrl().equals(newItem.getImageUrl()) &&
                                oldItem.getName().equals(newItem.getName()) &&
                                oldItem.getPrice().equals(newItem.getPrice()) &&
                                oldItem.getStar() == newItem.getStar();
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
        Furniture furniture = getItem(position);

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemFurnitureBinding binding;

        public ItemViewHolder(ItemFurnitureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Furniture furniture) {
            binding.textViewProductName.setText(furniture.getName());
            binding.textViewPrice.setText(furniture.getPrice().toString());
            binding.textViewRating.setText(furniture.getStar());
        }
    }
}
