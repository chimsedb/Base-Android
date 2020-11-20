package com.example.fooddelivery.ui.fragment.cart;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentCartBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;

import javax.inject.Inject;

public class CartFragment extends BaseFragment<FragmentCartBinding, CartViewModel> implements CartNavigator {
    @Inject
    CartAdapter cartAdapter;

    private FragmentCartBinding binding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cart;
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
        viewModel.getCartCategoryFood();
        viewModel.setCartAdapter(cartAdapter);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        binding.rcCart.setLayoutManager(manager);
        binding.rcCart.setAdapter(cartAdapter);
        binding.rcCart.addItemDecoration(new CardPaddingGridDecorator());
    }

    @Override
    public void openOrderPlaceScreen() {
        ((MainActivity) getActivity()).hideBadge();
        ((MainActivity) getActivity()).navigateFragment(R.id.action_cartFragment_to_orderPlaceFragment);
    }
}
