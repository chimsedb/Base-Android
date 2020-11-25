package com.example.fooddelivery.ui.fragment.menu;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentMenuBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;
import com.example.fooddelivery.ui.fragment.cart.CartItemViewModel;
import com.example.fooddelivery.utils.AppConstants;

import javax.inject.Inject;

import static com.example.fooddelivery.utils.AppConstants.CartType.ADD;
import static com.example.fooddelivery.utils.AppConstants.CartType.REMOVE;
import static com.example.fooddelivery.utils.AppConstants.RESTAURANT_ID;

public class MenuFragment extends BaseFragment<FragmentMenuBinding, MenuViewModel> implements MenuNavigator,
        MenuItemViewModel.CallBackToFragment {

    @Inject
    MenuAdapter menuAdapter;

    private FragmentMenuBinding binding;

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_menu;
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
        viewModel.setMenuAdapter(menuAdapter);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        binding.rcFood.setLayoutManager(manager);
        binding.rcFood.setAdapter(menuAdapter);
        binding.rcFood.addItemDecoration(new CardPaddingGridDecorator());
        menuAdapter.setCallBackToFragment(this);
        viewModel.getListFoodOfRestaurant(getArguments().getInt(RESTAURANT_ID));
    }

    @Override
    public void addFoodToCard(int id) {
        ((MainActivity) getActivity()).setBadge(id, ADD);
    }
}
