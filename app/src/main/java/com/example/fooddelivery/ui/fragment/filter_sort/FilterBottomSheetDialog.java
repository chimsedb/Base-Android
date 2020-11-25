package com.example.fooddelivery.ui.fragment.filter_sort;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.RestaurantResponse;
import com.example.fooddelivery.databinding.BottomSheetSortFilterBinding;
import com.example.fooddelivery.di.component.BottomSheetDialogComponent;
import com.example.fooddelivery.ui.activity.base.BaseBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.home.HomeFragment;

import java.util.List;

import javax.inject.Inject;

public class FilterBottomSheetDialog extends BaseBottomSheetDialog<BottomSheetSortFilterBinding, FilterViewModel> implements FilterNavigator {

    @Inject
    FilterViewModel viewModel;

    @Inject
    FilterAdapter filterAdapter;

    BottomSheetSortFilterBinding binding;

    private HomeFragment homeFragment;

    public static String TAG = FilterBottomSheetDialog.class.getName();

    public static FilterBottomSheetDialog newInstance() {
        return new FilterBottomSheetDialog();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        setUpWithFilterAdapter();
    }

    private void setUpWithFilterAdapter() {
        viewModel.setFilterAdapter(filterAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        binding.rcFilter.setLayoutManager(layoutManager);
        binding.rcFilter.setAdapter(filterAdapter);
        viewModel.getListFoodType();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.bottom_sheet_sort_filter;
    }

    @Override
    public void performDependencyInjection(BottomSheetDialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void updateRestaurantFilter(List<RestaurantResponse> response) {
        homeFragment.getRestaurantAdapter().setItems(response);
    }

    @Override
    public void closeDialog() {
        dismiss();
    }

    public void setHomeFragment(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }
}
