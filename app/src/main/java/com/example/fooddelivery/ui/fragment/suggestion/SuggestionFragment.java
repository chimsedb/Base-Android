package com.example.fooddelivery.ui.fragment.suggestion;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentSuggestionBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.example.fooddelivery.utils.AppConstants.FOOD_ID;

public class SuggestionFragment extends BaseFragment<FragmentSuggestionBinding, SuggestionViewModel> implements SuggestionNavigator {

    @Inject
    SuggestionAdapter suggestionAdapter;

    private FragmentSuggestionBinding binding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_suggestion;
    }

    public static SuggestionFragment newInstance() {
        return new SuggestionFragment();
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getFavoriteFood(getArguments().getInt(FOOD_ID));
        setUp();
    }

    private void setUp() {
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        setUpWithSuggestionAdapter();
    }

    private void setUpWithSuggestionAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcFood.setLayoutManager(manager);
        binding.rcFood.setAdapter(suggestionAdapter);
        suggestionAdapter.setActivity((MainActivity) getActivity());
        viewModel.setSuggestionAdapter(suggestionAdapter);
        viewModel.getListFavoriteFood();
    }
}
