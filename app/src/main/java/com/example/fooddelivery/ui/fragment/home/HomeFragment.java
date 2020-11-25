package com.example.fooddelivery.ui.fragment.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentHomeBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.home.adapter.RestaurantAdapter;
import com.example.fooddelivery.ui.fragment.home.adapter.FavoriteFoodAdapter;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> implements HomeNavigator {

    public static final String TAG = HomeFragment.class.getName();
    @Inject
    FavoriteFoodAdapter favoriteFoodAdapter;

    @Inject
    RestaurantAdapter restaurantAdapter;

    @Inject
    FilterBottomSheetDialog filterBottomSheetDialog;

    private FragmentHomeBinding binding;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.setNavigator(this);
        binding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        setUpWithOfferAdapter();
        setUpWithFoodAdapter();
        viewModel.getFavoriteFood();
        viewModel.getRestaurantNearYou();
    }

    private void setUpWithOfferAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rcSales.setLayoutManager(manager);
        binding.rcSales.setAdapter(favoriteFoodAdapter);
        viewModel.setFavoriteFoodAdapter(favoriteFoodAdapter);
        favoriteFoodAdapter.setActivity((MainActivity) getActivity());
    }

    private void setUpWithFoodAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcFood.setLayoutManager(manager);
        binding.rcFood.setAdapter(restaurantAdapter);
        viewModel.setRestaurantAdapter(restaurantAdapter);
        restaurantAdapter.setActivity((MainActivity) getActivity());
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openDialogFilerAndSort() {
        filterBottomSheetDialog.show(getFragmentManager(), FilterBottomSheetDialog.TAG);
        filterBottomSheetDialog.setHomeFragment(this);
    }

    @Override
    public void openMyLocation() {
        ((MainActivity) getActivity()).navigateFragment(R.id.action_homeFragment_to_myLocationFragment);
    }

    public RestaurantAdapter getRestaurantAdapter() {
        return restaurantAdapter;
    }
}
