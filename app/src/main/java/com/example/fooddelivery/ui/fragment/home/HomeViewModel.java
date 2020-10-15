package com.example.fooddelivery.ui.fragment.home;

import android.util.Log;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    public void openDialogFilerAndSort() {
        getNavigator().openDialogFilerAndSort();
    }

    public void openMyLocation(){
        getNavigator().openMyLocation();
    }
}
