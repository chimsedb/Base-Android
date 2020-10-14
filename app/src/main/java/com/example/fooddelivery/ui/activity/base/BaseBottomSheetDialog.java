package com.example.fooddelivery.ui.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.fooddelivery.MyApplication;
import com.example.fooddelivery.di.component.BottomSheetDialogComponent;
import com.example.fooddelivery.di.component.DaggerBottomSheetDialogComponent;
import com.example.fooddelivery.di.component.DaggerFragmentComponent;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.di.module.BottomSheetDialogModule;
import com.example.fooddelivery.di.module.FragmentModule;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import javax.inject.Inject;

public abstract class BaseBottomSheetDialog<T extends ViewDataBinding, V extends BaseViewModel> extends BottomSheetDialogFragment {
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        rootView = viewDataBinding.getRoot();
        return rootView;
    }

    public abstract void performDependencyInjection(BottomSheetDialogComponent buildComponent);

    private BottomSheetDialogComponent getBuildComponent() {
        return DaggerBottomSheetDialogComponent.builder()
                .appComponent(((MyApplication) (getContext().getApplicationContext())).appComponent)
                .bottomSheetDialogModule(new BottomSheetDialogModule(this,getContext()))
                .build();
    }
}
