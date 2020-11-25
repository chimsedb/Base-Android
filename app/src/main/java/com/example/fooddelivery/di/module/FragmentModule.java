package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseFragment;
import com.example.fooddelivery.ui.fragment.add_new_card.AddNewCardViewModel;
import com.example.fooddelivery.ui.fragment.cart.CartAdapter;
import com.example.fooddelivery.ui.fragment.cart.CartViewModel;
import com.example.fooddelivery.ui.fragment.filter_sort.FilterBottomSheetDialog;
import com.example.fooddelivery.ui.fragment.home.adapter.RestaurantAdapter;
import com.example.fooddelivery.ui.fragment.home.HomeViewModel;
import com.example.fooddelivery.ui.fragment.home.adapter.FavoriteFoodAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuAdapter;
import com.example.fooddelivery.ui.fragment.menu.MenuViewModel;
import com.example.fooddelivery.ui.fragment.more.MoreViewModel;
import com.example.fooddelivery.ui.fragment.my_location.MyLocationViewModel;
import com.example.fooddelivery.ui.fragment.order_place.OrderPlaceViewModel;
import com.example.fooddelivery.ui.fragment.payment_methods.PaymentMethodAdapter;
import com.example.fooddelivery.ui.fragment.payment_methods.PaymentMethodViewModel;
import com.example.fooddelivery.ui.fragment.search.SearchVPAdapter;
import com.example.fooddelivery.ui.fragment.search.SearchViewModel;
import com.example.fooddelivery.ui.fragment.search.dishs.DishAdapter;
import com.example.fooddelivery.ui.fragment.search.dishs.DishViewModel;
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
    HomeViewModel provideHomeViewModel(DataManager dataManager) {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(dataManager);
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(HomeViewModel.class);
    }

    @Provides
    SearchViewModel provideOfferViewModel(DataManager dataManager) {
        Supplier<SearchViewModel> supplier = () -> new SearchViewModel(dataManager);
        ViewModelProviderFactory<SearchViewModel> factory = new ViewModelProviderFactory<>(SearchViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SearchViewModel.class);
    }

    @Provides
    SuggestionViewModel provideSuggestionViewModel(DataManager dataManager) {
        Supplier<SuggestionViewModel> supplier = () -> new SuggestionViewModel(dataManager);
        ViewModelProviderFactory<SuggestionViewModel> factory = new ViewModelProviderFactory<>(SuggestionViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SuggestionViewModel.class);
    }

    @Provides
    MenuViewModel provideMenuViewModel(DataManager dataManager) {
        Supplier<MenuViewModel> supplier = () -> new MenuViewModel(dataManager);
        ViewModelProviderFactory<MenuViewModel> factory = new ViewModelProviderFactory<>(MenuViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MenuViewModel.class);
    }

    @Provides
    DishViewModel provideDishViewModel(DataManager dataManager) {
        Supplier<DishViewModel> supplier = () -> new DishViewModel(context, dataManager);
        ViewModelProviderFactory<DishViewModel> factory = new ViewModelProviderFactory<>(DishViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(DishViewModel.class);
    }

    @Provides
    RestaurantViewModel provideRestaurantViewModel(DataManager dataManager) {
        Supplier<RestaurantViewModel> supplier = () -> new RestaurantViewModel(context, dataManager);
        ViewModelProviderFactory<RestaurantViewModel> factory = new ViewModelProviderFactory<>(RestaurantViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(RestaurantViewModel.class);
    }

    @Provides
    CartViewModel provideCartViewModel(DataManager dataManager) {
        Supplier<CartViewModel> supplier = () -> new CartViewModel(dataManager);
        ViewModelProviderFactory<CartViewModel> factory = new ViewModelProviderFactory<>(CartViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(CartViewModel.class);
    }

    @Provides
    MyLocationViewModel provideMyLocationViewModel(DataManager dataManager) {
        Supplier<MyLocationViewModel> supplier = () -> new MyLocationViewModel(dataManager);
        ViewModelProviderFactory<MyLocationViewModel> factory = new ViewModelProviderFactory<>(MyLocationViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MyLocationViewModel.class);
    }

    @Provides
    SetLocationViewModel provideSetLocationViewModel(DataManager dataManager) {
        Supplier<SetLocationViewModel> supplier = () -> new SetLocationViewModel(dataManager);
        ViewModelProviderFactory<SetLocationViewModel> factory = new ViewModelProviderFactory<>(SetLocationViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SetLocationViewModel.class);
    }

    @Provides
    MoreViewModel provideMoreViewModel(DataManager dataManager) {
        Supplier<MoreViewModel> supplier = () -> new MoreViewModel(dataManager);
        ViewModelProviderFactory<MoreViewModel> factory = new ViewModelProviderFactory<>(MoreViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MoreViewModel.class);
    }

    @Provides
    PaymentMethodViewModel providePaymentMethodViewModel(DataManager dataManager) {
        Supplier<PaymentMethodViewModel> supplier = () -> new PaymentMethodViewModel(context,dataManager);
        ViewModelProviderFactory<PaymentMethodViewModel> factory = new ViewModelProviderFactory<>(PaymentMethodViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(PaymentMethodViewModel.class);
    }

    @Provides
    AddNewCardViewModel provideAddNewCardViewModel(DataManager dataManager) {
        Supplier<AddNewCardViewModel> supplier = () -> new AddNewCardViewModel(context,dataManager);
        ViewModelProviderFactory<AddNewCardViewModel> factory = new ViewModelProviderFactory<>(AddNewCardViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(AddNewCardViewModel.class);
    }

    @Provides
    OrderPlaceViewModel provideOrderPlaceViewModel(DataManager dataManager) {
        Supplier<OrderPlaceViewModel> supplier = () -> new OrderPlaceViewModel(dataManager);
        ViewModelProviderFactory<OrderPlaceViewModel> factory = new ViewModelProviderFactory<>(OrderPlaceViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(OrderPlaceViewModel.class);
    }

    //Adapter RecyclerView

    @Provides
    FavoriteFoodAdapter provideOfferAdapter() {
        return new FavoriteFoodAdapter();
    }

    @Provides
    RestaurantAdapter provideFoodAdapter() {
        return new RestaurantAdapter();
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
    com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantAdapter provideRestaurantAdapter() {
        return new com.example.fooddelivery.ui.fragment.search.restaurant.RestaurantAdapter();
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
    FilterBottomSheetDialog provideFilterBottomSheetFragment() {
        return FilterBottomSheetDialog.newInstance();
    }

    @Provides
    SearchVPAdapter provideSearchVPAdapter() {
        return new SearchVPAdapter(fragment.getChildFragmentManager());
    }

    @Provides
    PaymentMethodAdapter providePaymentMethodAdapter() {
        return new PaymentMethodAdapter();
    }
}
