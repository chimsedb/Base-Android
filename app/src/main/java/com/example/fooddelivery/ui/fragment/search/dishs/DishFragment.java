package com.example.fooddelivery.ui.fragment.search.dishs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentDishBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DishFragment extends BaseFragment<FragmentDishBinding, DishViewModel> implements DishNavigator {
    @Inject
    DishAdapter dishAdapter;

    private FragmentDishBinding binding;

    public static DishFragment newInstance() {
        return new DishFragment();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dish;
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
        setUpWithDishRC();
    }

    private void setUpWithDishRC() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        binding.rcDish.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        binding.rcDish.addItemDecoration(new CardPaddingGridDecorator());
        binding.rcDish.setAdapter(dishAdapter);
        dishAdapter.addItems(list);
    }
}
