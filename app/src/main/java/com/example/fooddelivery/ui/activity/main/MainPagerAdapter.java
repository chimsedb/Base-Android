package com.example.fooddelivery.ui.activity.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fooddelivery.ui.fragment.home.HomeFragment;
import com.example.fooddelivery.ui.fragment.search.SearchFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount = 2;

    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return SearchFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
