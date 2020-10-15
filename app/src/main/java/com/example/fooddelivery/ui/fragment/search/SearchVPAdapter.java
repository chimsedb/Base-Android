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
                return RestaurantFragment.newInstance();
            case 1:
                return DishFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
}
