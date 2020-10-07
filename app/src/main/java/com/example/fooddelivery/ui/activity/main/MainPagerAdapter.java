package com.example.fooddelivery.ui.activity.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.tabCount = 0;
    }

    public void setCount(int count) {
        tabCount = count;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
//                return BlogFragment.newInstance();
            case 1:
//                return OpenSourceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
