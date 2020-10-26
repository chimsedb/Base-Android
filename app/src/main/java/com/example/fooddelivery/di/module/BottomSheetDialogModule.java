package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterAdapter;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterAndSortViewModel;
import com.example.fooddelivery.ui.fragment.filter_sort.SortAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class BottomSheetDialogModule {
    private final Context context;
    private BaseBottomSheetDialog<?, ?> dialog;

    public BottomSheetDialogModule(BaseBottomSheetDialog<?, ?> dialog, Context context) {
        this.dialog = dialog;
        this.context = context;
    }

    @Provides
    FilterAndSortViewModel provideFilterAndSortViewModel(DataManager dataManager) {
        Supplier<FilterAndSortViewModel> supplier = () -> new FilterAndSortViewModel(dataManager);
        ViewModelProviderFactory<FilterAndSortViewModel> factory = new ViewModelProviderFactory<>(FilterAndSortViewModel.class, supplier);
        return new ViewModelProvider(dialog, factory).get(FilterAndSortViewModel.class);
    }

    @Provides
    SortAdapter provideSortAdapter() {
        return new SortAdapter();
    }

    @Provides
    FilterAdapter provideFilterAdapter() {
        return new FilterAdapter();
    }

}
