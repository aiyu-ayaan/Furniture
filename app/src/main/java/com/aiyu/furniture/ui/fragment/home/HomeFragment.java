package com.aiyu.furniture.ui.fragment.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.aiyu.furniture.R;
import com.aiyu.furniture.core.database.model.Category;
import com.aiyu.furniture.databinding.FragmentHomeBinding;
import com.aiyu.furniture.utils.BaseFragment;

import java.util.stream.Collectors;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        binding.recyclerViewFurniture.setAdapter(adapter);
        binding.recyclerViewFurniture.setHasFixedSize(true);
        binding.recyclerViewFurniture.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter.setItemOnClickListener(furnitureModel -> {
            var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(furnitureModel);
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });

        homeViewModel.getFurnitureData((furnitureModels, e) -> {
            if (e != null) {
                Toast.makeText(requireContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                return;
            }

            // Set the initial data - show all items by default
            adapter.submitList(furnitureModels);

            // Make sure "all" chip is checked by default
            binding.chipGroup.check(R.id.all);

            binding.chipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
                if (checkedIds.isEmpty()) {
                    // If nothing is selected, automatically select "all"
                    binding.chipGroup.check(R.id.all);
                    adapter.submitList(furnitureModels);
                    return;
                }

                int id = checkedIds.get(0);
                if (id == R.id.chair) {
                    adapter.submitList(furnitureModels.stream().filter(furnitureModel -> furnitureModel.getCategory().name().equals(Category.CHAIR.name())).collect(Collectors.toList()));
                    return;
                }
                if (id == R.id.sofa) {
                    adapter.submitList(furnitureModels.stream().filter(furnitureModel -> furnitureModel.getCategory().name().equals(Category.SOFA.name())).collect(Collectors.toList()));
                    return;
                }
                if (id == R.id.bed) {
                    adapter.submitList(furnitureModels.stream().filter(furnitureModel -> furnitureModel.getCategory().name().equals(Category.BED.name())).collect(Collectors.toList()));
                    return;
                }
                if (id == R.id.lamp) {
                    adapter.submitList(furnitureModels.stream().filter(furnitureModel -> furnitureModel.getCategory().name().equals(Category.LAMP.name())).collect(Collectors.toList()));
                    return;
                }
                if (id == R.id.all) {
                    adapter.submitList(furnitureModels);
                }
            });
        });
    }
}
