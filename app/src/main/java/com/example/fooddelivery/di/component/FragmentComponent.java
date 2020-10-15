package com.example.fooddelivery.di.component;

import com.example.fooddelivery.di.module.FragmentModule;
import com.example.fooddelivery.di.scope.FragmentScope;
import com.example.fooddelivery.ui.fragment.cart.CartFragment;
import com.example.fooddelivery.ui.fragment.home.HomeFragment;
import com.example.fooddelivery.ui.fragment.menu.MenuFragment;
import com.example.fooddelivery.ui.fragment.my_location.MyLocationFragment;
import com.example.fooddelivery.ui.fragment.search.SearchFragment;
import com.example.fooddelivery.ui.fragment.search.dishs.DishFragment;
import com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantFragment;
import com.example.fooddelivery.ui.fragment.set_location.SetLocationFragment;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionFragment;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);

    void inject(SearchFragment searchFragment);

    void inject(SuggestionFragment suggestionFragment);

    void inject(MenuFragment menuFragment);

    void inject(DishFragment dishFragment);

    void inject(RestaurantFragment restaurantFragment);

    void inject(CartFragment cartFragment);

    void inject(MyLocationFragment myLocationFragment);

    void inject(SetLocationFragment setLocationFragment);
}
