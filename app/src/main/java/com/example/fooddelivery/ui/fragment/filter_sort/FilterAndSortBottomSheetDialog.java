package com.example.fooddelivery.ui.fragment.filter_sort;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.BottomSheetSortFilterBinding;
import com.example.fooddelivery.di.component.BottomSheetDialogComponent;
import com.example.fooddelivery.ui.activity.base.BaseBottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FilterAndSortBottomSheetDialog extends BaseBottomSheetDialog<BottomSheetSortFilterBinding, FilterAndSortViewModel> {

    @Inject
    FilterAndSortViewModel viewModel;

    @Inject
    SortAdapter sortAdapter;

    @Inject
    FilterAdapter filterAdapter;

    BottomSheetSortFilterBinding binding;

    public static String TAG = FilterAndSortBottomSheetDialog.class.getName();

    public static FilterAndSortBottomSheetDialog newInstance() {
        return new FilterAndSortBottomSheetDialog();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        binding = getViewDataBinding();
        setUpWithSortAdapter();
        setUpWithFilterAdapter();
    }

    private void setUpWithFilterAdapter() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(String.valueOf(i));
        }
        filterAdapter.addItems(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rcFilter.setLayoutManager(layoutManager);
        binding.rcFilter.setAdapter(filterAdapter);
    }

    private void setUpWithSortAdapter() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(String.valueOf(i));
        }
        sortAdapter.addItems(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rcSort.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                LinearLayout.VERTICAL);
        binding.rcSort.addItemDecoration(dividerItemDecoration);
        binding.rcSort.setAdapter(sortAdapter);
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
}
