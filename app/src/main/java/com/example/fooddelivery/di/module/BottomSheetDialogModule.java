package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterAdapter;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterViewModel;

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
    FilterViewModel provideFilterAndSortViewModel(DataManager dataManager) {
        Supplier<FilterViewModel> supplier = () -> new FilterViewModel(context,dataManager);
        ViewModelProviderFactory<FilterViewModel> factory = new ViewModelProviderFactory<>(FilterViewModel.class, supplier);
        return new ViewModelProvider(dialog, factory).get(FilterViewModel.class);
    }

    @Provides
    FilterAdapter provideFilterAdapter() {
        return new FilterAdapter();
    }

}
