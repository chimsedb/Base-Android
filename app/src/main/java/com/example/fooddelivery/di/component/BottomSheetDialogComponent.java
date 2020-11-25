package com.example.fooddelivery.di.component;

import com.example.fooddelivery.di.module.BottomSheetDialogModule;
import com.example.fooddelivery.di.scope.BottomSheetDialogScope;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterBottomSheetDialog;

import dagger.Component;

@BottomSheetDialogScope
@Component(modules = BottomSheetDialogModule.class, dependencies = AppComponent.class)
public interface BottomSheetDialogComponent {
    void inject(FilterBottomSheetDialog fragment);
}
