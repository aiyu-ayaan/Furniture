package com.aiyu.furniture.ui.fragment.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.FragmentHomeBinding;
import com.aiyu.furniture.utils.BaseFragment;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        binding.recyclerViewFurniture.setAdapter(adapter);
        binding.recyclerViewFurniture.setHasFixedSize(true);
        binding.recyclerViewFurniture.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
//                if (checkedIds.size() == 0) {
//                    adapter.submitList(null);
//                    return;
//                }
//                int id = checkedIds.get(0);
//                switch (id) {
//                    case R.id.all:
//                        adapter.submitList(new ArrayList<>());
//                        break;
//                    case R.id.chair:
//                        adapter.submitList(new ArrayList<>());
//                        break;
//                    case R.id.sofa:
//                        adapter.submitList(new ArrayList<>());
//                        break;
//                    case R.id.bed:
//                        adapter.submitList(new ArrayList<>());
//                        break;
//                    case R.id.lamp:
//                        adapter.submitList(new ArrayList<>());
//                        break;
//                }
            }
        });
    }
}
