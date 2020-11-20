package com.example.fooddelivery.ui.fragment.menu;

import android.util.Log;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MenuViewModel extends BaseViewModel<MenuNavigator> {

    private MenuAdapter menuAdapter;

    public void setMenuAdapter(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
    }

    public MenuViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void getListFoodOfRestaurant(int id){
        getDataManager().getListFoodOfRestaurant(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<FoodOfRestaurantResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<FoodOfRestaurantResponse> responses) {
                       menuAdapter.setItems(responses);
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
}
