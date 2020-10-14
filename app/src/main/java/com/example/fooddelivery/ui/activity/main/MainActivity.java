package com.example.fooddelivery.ui.activity.main;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityMainBinding;
import com.example.fooddelivery.di.component.ActivityComponent;
import com.example.fooddelivery.ui.activity.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    MainPagerAdapter mainPagerAdapter;

    private NavController navController;

    private ActivityMainBinding activityMainBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }

    private void setUp() {
        activityMainBinding = getViewDataBinding();
        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_home_fragment)).getNavController();
        navController.setGraph(navController.getNavInflater().inflate(R.navigation.home_nav));
        NavigationUI.setupWithNavController(activityMainBinding.myBottomNavigation, navController);

        activityMainBinding.myBottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navController.setGraph(navController.getNavInflater().inflate(R.navigation.home_nav));
                    break;
                case R.id.navigation_offers:
                    navController.setGraph(navController.getNavInflater().inflate(R.navigation.offers_nav));
                    break;
            }
            return true;
        });
    }


    public void navigateFragment(int id) {
        navController.navigate(id);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}
