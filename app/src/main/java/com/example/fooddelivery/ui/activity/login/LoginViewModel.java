package com.example.fooddelivery.ui.activity.login;

import android.util.Log;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public void login(){
        getNavigator().login();
    }
}
