package com.example.fooddelivery.ui.fragment.menu;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class MenuViewModel extends BaseViewModel<MenuNavigator> {
    public void finishThis() {
        getNavigator().finishThis();
    }
}
