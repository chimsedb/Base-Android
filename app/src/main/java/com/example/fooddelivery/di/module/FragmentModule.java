package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterAndSortBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.home.FoodAdapter;
import com.example.fooddelivery.ui.fragment.home.HomeViewModel;
import com.example.fooddelivery.ui.fragment.home.OfferAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuViewModel;
import com.example.fooddelivery.ui.fragment.offers.OfferViewModel;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionAdapter;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private final Context context;
    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment, Context context) {
        this.fragment = fragment;
        this.context = context;
    }

    @Provides
    HomeViewModel provideHomeViewModel() {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel();
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(HomeViewModel.class);
    }

    @Provides
    OfferViewModel provideOfferViewModel() {
        Supplier<OfferViewModel> supplier = () -> new OfferViewModel();
        ViewModelProviderFactory<OfferViewModel> factory = new ViewModelProviderFactory<>(OfferViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(OfferViewModel.class);
    }

    @Provides
    SuggestionViewModel provideSuggestionViewModel() {
        Supplier<SuggestionViewModel> supplier = () -> new SuggestionViewModel();
        ViewModelProviderFactory<SuggestionViewModel> factory = new ViewModelProviderFactory<>(SuggestionViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SuggestionViewModel.class);
    }

    @Provides
    MenuViewModel provideMenuViewModel() {
        Supplier<MenuViewModel> supplier = () -> new MenuViewModel();
        ViewModelProviderFactory<MenuViewModel> factory = new ViewModelProviderFactory<>(MenuViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MenuViewModel.class);
    }

    @Provides
    OfferAdapter provideOfferAdapter() {
        return new OfferAdapter();
    }

    @Provides
    FoodAdapter provideFoodAdapter() {
        return new FoodAdapter();
    }

    @Provides
    FilterAndSortBottomSheetDialog provideFilterBottomSheetFragment() {
        return FilterAndSortBottomSheetDialog.newInstance();
    }

    @Provides
    SuggestionAdapter provideSuggestionAdapter() {
        return new SuggestionAdapter();
    }

    @Provides
    MenuAdapter provideMenuAdapter() {
        return new MenuAdapter();
    }
}
