package com.example.fooddelivery.ui.fragment.home;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantNearYouResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.fragment.home.adapter.FavoriteFoodAdapter;
import com.example.fooddelivery.ui.fragment.home.adapter.RestaurantNearYouAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    private RestaurantNearYouAdapter restaurantNearYouAdapter;
    private FavoriteFoodAdapter favoriteFoodAdapter;

    public HomeViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setRestaurantNearYouAdapter(RestaurantNearYouAdapter restaurantNearYouAdapter) {
        this.restaurantNearYouAdapter = restaurantNearYouAdapter;
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
                .subscribe(new Observer<List<RestaurantNearYouResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<RestaurantNearYouResponse> responses) {
                       restaurantNearYouAdapter.setList(responses);
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

    public void getFavoriteFood(){
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
