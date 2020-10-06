package com.example.fooddelivery.ui.main;

import android.content.Context;
import android.util.Log;

import com.example.fooddelivery.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final MainActivity context;

    public MainViewModel(MainActivity context) {
        this.context = context;
    }

    public MainActivity getContext() {
        return context;
    }
}
