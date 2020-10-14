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
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        setUpWithSuggestionAdapter();
    }

    private void setUpWithSuggestionAdapter() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1");
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcFood.setLayoutManager(manager);
        binding.rcFood.setAdapter(suggestionAdapter);
        suggestionAdapter.setActivity((MainActivity) getActivity());
        suggestionAdapter.addItems(list);
    }
}
