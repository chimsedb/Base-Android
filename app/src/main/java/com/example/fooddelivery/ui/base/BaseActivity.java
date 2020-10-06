package com.example.fooddelivery.ui.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.fooddelivery.MyApplication;
import com.example.fooddelivery.di.component.ActivityComponent;
import com.example.fooddelivery.di.component.DaggerActivityComponent;
import com.example.fooddelivery.di.module.ActivityModule;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private T viewDataBinding;

    @Inject
    protected V viewModel;

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract int getBindingVariable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((MyApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }

}
