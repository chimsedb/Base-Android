package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.fragment.cart.CartAdapter;
import com.example.fooddelivery.ui.fragment.cart.CartViewModel;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterAndSortBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.home.FoodAdapter;
import com.example.fooddelivery.ui.fragment.home.HomeViewModel;
import com.example.fooddelivery.ui.fragment.home.OfferAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuViewModel;
import com.example.fooddelivery.ui.fragment.my_location.MyLocationViewModel;
import com.example.fooddelivery.ui.fragment.search.SearchVPAdapter;
import com.example.fooddelivery.ui.fragment.search.SearchViewModel;
import com.example.fooddelivery.ui.fragment.search.dishs.DishAdapter;
import com.example.fooddelivery.ui.fragment.search.dishs.DishViewModel;
import com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantAdapter;
import com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantViewModel;
import com.example.fooddelivery.ui.fragment.set_location.SetLocationViewModel;
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

    // ViewModel

    @Provides
    HomeViewModel provideHomeViewModel() {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel();
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(HomeViewModel.class);
    }

    @Provides
    SearchViewModel provideOfferViewModel() {
        Supplier<SearchViewModel> supplier = () -> new SearchViewModel();
        ViewModelProviderFactory<SearchViewModel> factory = new ViewModelProviderFactory<>(SearchViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SearchViewModel.class);
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
    DishViewModel provideDishViewModel() {
        Supplier<DishViewModel> supplier = () -> new DishViewModel();
        ViewModelProviderFactory<DishViewModel> factory = new ViewModelProviderFactory<>(DishViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(DishViewModel.class);
    }

    @Provides
    RestaurantViewModel provideRestaurantViewModel() {
        Supplier<RestaurantViewModel> supplier = () -> new RestaurantViewModel();
        ViewModelProviderFactory<RestaurantViewModel> factory = new ViewModelProviderFactory<>(RestaurantViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(RestaurantViewModel.class);
    }

    @Provides
    CartViewModel provideCartViewModel() {
        Supplier<CartViewModel> supplier = () -> new CartViewModel();
        ViewModelProviderFactory<CartViewModel> factory = new ViewModelProviderFactory<>(CartViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(CartViewModel.class);
    }

    @Provides
    MyLocationViewModel provideMyLocationViewModel() {
        Supplier<MyLocationViewModel> supplier = () -> new MyLocationViewModel();
        ViewModelProviderFactory<MyLocationViewModel> factory = new ViewModelProviderFactory<>(MyLocationViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MyLocationViewModel.class);
    }

    @Provides
    SetLocationViewModel provideSetLocationViewModel() {
        Supplier<SetLocationViewModel> supplier = () -> new SetLocationViewModel();
        ViewModelProviderFactory<SetLocationViewModel> factory = new ViewModelProviderFactory<>(SetLocationViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SetLocationViewModel.class);
    }

    //Adapter RecyclerView

    @Provides
    OfferAdapter provideOfferAdapter() {
        return new OfferAdapter();
    }

    @Provides
    FoodAdapter provideFoodAdapter() {
        return new FoodAdapter();
    }

    @Provides
    SuggestionAdapter provideSuggestionAdapter() {
        return new SuggestionAdapter();
    }

    @Provides
    MenuAdapter provideMenuAdapter() {
        return new MenuAdapter();
    }

    @Provides
    RestaurantAdapter provideRestaurantAdapter() {
        return new RestaurantAdapter();
    }

    @Provides
    DishAdapter provideDishAdapter() {
        return new DishAdapter();
    }

    @Provides
    CartAdapter provideCartAdapter() {
        return new CartAdapter();
    }

    // Other
    @Provides
    FilterAndSortBottomSheetDialog provideFilterBottomSheetFragment() {
        return FilterAndSortBottomSheetDialog.newInstance();
    }

    @Provides
    SearchVPAdapter provideSearchVPAdapter() {
        return new SearchVPAdapter(fragment.getChildFragmentManager());
    }


}
