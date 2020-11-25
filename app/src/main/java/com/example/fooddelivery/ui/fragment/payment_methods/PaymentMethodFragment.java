package com.example.fooddelivery.ui.fragment.payment_methods;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentPaymentMethodBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import static com.example.fooddelivery.utils.AppConstants.BUNDLE_FROM_CART_FRAGMENT;

public class PaymentMethodFragment extends BaseFragment<FragmentPaymentMethodBinding, PaymentMethodViewModel> implements PaymentMethodNavigator {
    @Inject
    PaymentMethodAdapter adapter;

    private FragmentPaymentMethodBinding binding;
    private boolean fromCartFragment = false;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_payment_method;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        if (getArguments() != null) {
            fromCartFragment = getArguments().getBoolean(BUNDLE_FROM_CART_FRAGMENT);
        }
        viewModel.setFromCartFragment(fromCartFragment);
        setUpWithPaymentRC();
    }

    private void setUpWithPaymentRC() {
        adapter.setViewModel(viewModel);
        viewModel.setPaymentMethodAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcCard.setLayoutManager(manager);
        binding.rcCard.setAdapter(adapter);
        adapter.setContext(getContext());
        viewModel.getListUserCard();
    }

    @Override
    public void addNewCard() {
        ((MainActivity) getActivity()).navigateFragment(R.id.action_paymentMethodFragment_to_addNewCardFragment);
    }

    @Override
    public void openOrderPlaceScreen() {
        ((MainActivity) getActivity()).navigateFragment(R.id.action_paymentMethodFragment_to_orderPlaceFragment);
    }
}
