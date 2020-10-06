package com.example.fooddelivery.ui.login;

import android.util.Log;

import com.example.fooddelivery.ui.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public void login(){
        Log.d("123123","123123");
        getNavigator().login();
    }
}
