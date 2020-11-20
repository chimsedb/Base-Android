package com.example.fooddelivery.ui.activity.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.MyApplication;
import com.example.fooddelivery.di.component.DaggerFragmentComponent;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.di.module.FragmentModule;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionFragment;

import javax.inject.Inject;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {
    private View rootView;
    private T viewDataBinding;

    @Inject
    protected V viewModel;

    public abstract int getBindingVariable();

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        rootView = viewDataBinding.getRoot();
        return rootView;
    }

    public abstract void performDependencyInjection(FragmentComponent buildComponent);

    private FragmentComponent getBuildComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(((MyApplication) (getContext().getApplicationContext())).appComponent)
                .fragmentModule(new FragmentModule(this, getContext()))
                .build();
    }

    public V getViewModel() {
        return viewModel;
    }
}
