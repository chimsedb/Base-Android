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
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MenuFragment extends BaseFragment<FragmentMenuBinding, MenuViewModel> implements MenuNavigator {

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
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1");
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        binding.rcFood.setLayoutManager(manager);
        binding.rcFood.setAdapter(menuAdapter);
        binding.rcFood.addItemDecoration(new MenuDecorator());
        menuAdapter.addItems(list);
    }

    @Override
    public void finishThis() {
        ((MainActivity) getActivity()).navigateFragment(R.id.action_menuFragment_to_suggestionFragment);
    }
}
