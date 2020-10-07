package com.example.fooddelivery.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityLoginBinding;
import com.example.fooddelivery.di.component.ActivityComponent;
import com.example.fooddelivery.ui.activity.base.BaseActivity;
import com.example.fooddelivery.ui.activity.main.MainActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void login() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
