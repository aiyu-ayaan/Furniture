package com.aiyu.furniture.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aiyu.furniture.R;
import com.aiyu.furniture.databinding.ActivityMainBinding;
import com.aiyu.furniture.utils.Items;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {


    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    @Inject
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        var navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) navController = navHostFragment.getNavController();
        else throw new IllegalStateException("NavHostFragment not found");
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.cartFragment, R.id.profileFragment, R.id.logInFragment).build();

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        binding.bottomNavigationView.setOnItemReselectedListener(item -> {
        });
        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if (navDestination.getId() == R.id.homeFragment || navDestination.getId() == R.id.cartFragment || navDestination.getId() == R.id.profileFragment) {
                binding.bottomNavigationView.setVisibility(View.VISIBLE);
            } else {
                binding.bottomNavigationView.setVisibility(View.GONE);
            }
        });

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> {
//            items.fetchFoodImages();
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}