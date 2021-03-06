package com.example.fooddelivery.ui.fragment.my_location;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class MyLocationViewModel extends BaseViewModel<MyLocationNavigator> {
    public MyLocationViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void openSetLocation(){
        getNavigator().openSetLocation();
    }
}
