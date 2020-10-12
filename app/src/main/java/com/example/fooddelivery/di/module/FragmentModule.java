package com.example.fooddelivery.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.fragment.home.HomeViewModel;
import com.example.fooddelivery.ui.fragment.home.OfferAdapter;
import com.example.fooddelivery.ui.fragment.offers.OfferViewModel;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
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
    OfferAdapter provideOfferAdapter() {
        return new OfferAdapter();
    }
}
