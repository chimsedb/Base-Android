package com.example.fooddelivery.ui.activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityMainBinding;
import com.example.fooddelivery.di.component.ActivityComponent;
import com.example.fooddelivery.ui.activity.base.BaseActivity;
import com.example.fooddelivery.ui.fragment.home.HomeFragment;
import com.example.fooddelivery.ui.fragment.offers.OffersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    MainPagerAdapter mainPagerAdapter;

    private FragmentManager manager;
    private FragmentTransaction transaction;

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
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_page, new HomeFragment(), HomeFragment.TAG);
        transaction.commit();
        activityMainBinding.myBottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction = manager.beginTransaction();
                    transaction.replace(R.id.layout_page, new HomeFragment(), HomeFragment.TAG);
                    transaction.commit();
                    break;
                case R.id.navigation_offers:
                    transaction = manager.beginTransaction();
                    transaction.replace(R.id.layout_page, new OffersFragment(), OffersFragment.TAG);
                    transaction.commit();
                    break;
            }
            return true;
        });
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}
