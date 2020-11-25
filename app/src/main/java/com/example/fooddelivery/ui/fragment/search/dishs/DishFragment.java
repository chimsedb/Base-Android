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
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.utils.CardPaddingGridDecorator;

import javax.inject.Inject;

import static com.example.fooddelivery.utils.AppConstants.CartType.ADD;

public class DishFragment extends BaseFragment<FragmentDishBinding, DishViewModel> implements DishNavigator, DisItemViewModel.CallBackToFragment {
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
        viewModel.setRestaurantAdapter(dishAdapter);
        binding.rcDish.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        binding.rcDish.addItemDecoration(new CardPaddingGridDecorator());
        binding.rcDish.setAdapter(dishAdapter);
        dishAdapter.setActivity(getMainActivity());
        dishAdapter.setCallBackToFragment(this);
    }

    public MainActivity getMainActivity() {
        return ((MainActivity) getActivity());
    }

    @Override
    public void addFoodToCard(int id) {
        ((MainActivity) getActivity()).setBadge(id,ADD);
    }
}
