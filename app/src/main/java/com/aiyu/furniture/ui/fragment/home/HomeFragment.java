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
import com.aiyu.furniture.databinding.FragmentHomeBinding;
import com.aiyu.furniture.utils.BaseFragment;

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
            if (furnitureModels != null) {
                adapter.submitList(furnitureModels);
            }
        });
//        binding.chipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
////                if (checkedIds.size() == 0) {
////                    adapter.submitList(null);
////                    return;
////                }
////                int id = checkedIds.get(0);
////                switch (id) {
////                    case R.id.all:
////                        adapter.submitList(new ArrayList<>());
////                        break;
////                    case R.id.chair:
////                        adapter.submitList(new ArrayList<>());
////                        break;
////                    case R.id.sofa:
////                        adapter.submitList(new ArrayList<>());
////                        break;
////                    case R.id.bed:
////                        adapter.submitList(new ArrayList<>());
////                        break;
////                    case R.id.lamp:
////                        adapter.submitList(new ArrayList<>());
////                        break;
////                }
//        });
    }
}
