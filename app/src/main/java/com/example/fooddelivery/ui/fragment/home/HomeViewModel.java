package com.example.fooddelivery.ui.fragment.home;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.fragment.home.adapter.FavoriteFoodAdapter;
import com.example.fooddelivery.ui.fragment.home.adapter.RestaurantAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {
    public ObservableField<String> address = new ObservableField<>("");

    private RestaurantAdapter restaurantAdapter;
    private FavoriteFoodAdapter favoriteFoodAdapter;

    public HomeViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setRestaurantAdapter(RestaurantAdapter restaurantAdapter) {
        this.restaurantAdapter = restaurantAdapter;
        address.set(getDataManager().getCurrentAddress());
    }

    public void setFavoriteFoodAdapter(FavoriteFoodAdapter favoriteFoodAdapter) {
        this.favoriteFoodAdapter = favoriteFoodAdapter;
    }

    public void openDialogFilerAndSort() {
        getNavigator().openDialogFilerAndSort();
    }

    public void openMyLocation() {
        getNavigator().openMyLocation();
    }

    public void getRestaurantNearYou() {
        getDataManager().getListRestaurantNearYouResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<RestaurantResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<RestaurantResponse> responses) {
                        restaurantAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getFavoriteFood() {
        getDataManager().getFavoriteFoodResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<FavoriteFoodResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<FavoriteFoodResponse> responses) {
                        favoriteFoodAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
