package com.example.fooddelivery.ui.fragment.search;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentSearchBinding;
import com.example.fooddelivery.di.component.FragmentComponent;
import com.example.fooddelivery.ui.activity.base.BaseFragment;

import javax.inject.Inject;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> implements SearchNavigator {

    @Inject
    SearchVPAdapter searchVPAdapter;

    public static final String TAG = SearchFragment.class.getName();

    private FragmentSearchBinding binding;
    private int pageSelected;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        setUpWithSearchVp();
        setUpWithSearchBox();
    }

    private void setUpWithSearchVp() {
        binding.searchViewPager.setAdapter(searchVPAdapter);
        binding.searchTabLayout.setupWithViewPager(binding.searchViewPager);
        binding.searchViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageSelected = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpWithSearchBox() {
        binding.searchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                switch (pageSelected) {
                    case 0:
                        searchVPAdapter.getRestaurantFragment().getViewModel().searchRestaurantByName(query);
                        break;
                    case 1:
                        searchVPAdapter.getDishFragment().getViewModel().searchFoodByName(query);
                        break;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }
}
