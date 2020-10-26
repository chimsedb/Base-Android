package com.example.fooddelivery.ui.activity.base;

import androidx.lifecycle.ViewModel;

import com.example.fooddelivery.data.DataManager;

import java.lang.ref.WeakReference;

public class BaseViewModel<N> extends ViewModel {
    private final DataManager dataManager;

    private WeakReference<N> mNavigator;

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public BaseViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
