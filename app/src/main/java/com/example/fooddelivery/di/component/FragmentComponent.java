package com.example.fooddelivery.di.component;

import com.example.fooddelivery.di.module.FragmentModule;
import com.example.fooddelivery.di.scope.FragmentScope;
import com.example.fooddelivery.ui.fragment.home.HomeFragment;
import com.example.fooddelivery.ui.fragment.menu.MenuFragment;
import com.example.fooddelivery.ui.fragment.offers.OffersFragment;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionFragment;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);

    void inject(OffersFragment offersFragment);

    void inject(SuggestionFragment suggestionFragment);

    void inject(MenuFragment menuFragment);
}
