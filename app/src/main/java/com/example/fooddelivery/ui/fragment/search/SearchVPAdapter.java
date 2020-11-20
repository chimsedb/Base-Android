package com.example.fooddelivery.ui.fragment.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fooddelivery.ui.fragment.search.dishs.DishFragment;
import com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantFragment;

public class SearchVPAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = new String[]{"Restaurant", "Dish"};

    private RestaurantFragment restaurantFragment;
    private DishFragment dishFragment;

    public SearchVPAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                restaurantFragment = RestaurantFragment.newInstance();
                return restaurantFragment;
            case 1:
                dishFragment = DishFragment.newInstance();
                return dishFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    public RestaurantFragment getRestaurantFragment() {
        return restaurantFragment;
    }

    public DishFragment getDishFragment() {
        return dishFragment;
    }
}
