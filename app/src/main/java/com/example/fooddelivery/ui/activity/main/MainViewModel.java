package com.example.fooddelivery.ui.activity.main;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final MainActivity context;

    public MainViewModel(MainActivity context) {
        this.context = context;
    }

    public MainActivity getContext() {
        return context;
    }
}
