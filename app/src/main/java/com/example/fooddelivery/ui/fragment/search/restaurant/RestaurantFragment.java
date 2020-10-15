package com.example.fooddelivery.ui.fragment.search.restaurant;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentRestaurantBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RestaurantFragment extends BaseFragment<FragmentRestaurantBinding, RestaurantViewModel> implements RestaurantNavigator {
    @Inject
    RestaurantAdapter restaurantAdapter;

    private FragmentRestaurantBinding binding;

    public static RestaurantFragment newInstance() {
        return new RestaurantFragment();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_restaurant;
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
        setUpWihRestaurantRC();
    }

    private void setUpWihRestaurantRC() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        binding.rcRestaurant.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rcRestaurant.setAdapter(restaurantAdapter);
        restaurantAdapter.addItems(list);
        restaurantAdapter.setActivity((MainActivity) getActivity());
    }
}
