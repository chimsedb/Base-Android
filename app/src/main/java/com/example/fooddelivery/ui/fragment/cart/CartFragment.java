package com.example.fooddelivery.ui.fragment.cart;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentCardBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CartFragment extends BaseFragment<FragmentCardBinding, CartViewModel> implements CartNavigator {
    @Inject
    CartAdapter cartAdapter;

    private FragmentCardBinding binding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_card;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        setUpWithCartRC();
    }

    private void setUpWithCartRC() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        binding.rcCart.setLayoutManager(manager);
        binding.rcCart.setAdapter(cartAdapter);
        binding.rcCart.addItemDecoration(new CardPaddingGridDecorator());
        cartAdapter.addItems(list);
    }
}
