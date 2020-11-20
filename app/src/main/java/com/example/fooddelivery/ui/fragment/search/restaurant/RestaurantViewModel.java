package com.example.fooddelivery.ui.fragment.search.restaurant;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RestaurantViewModel extends BaseViewModel<RestaurantNavigator> {
    private final Context context;
    public ObservableField<String> titleSearch = new ObservableField<>();

    private RestaurantAdapter restaurantAdapter;

    public void setRestaurantAdapter(RestaurantAdapter restaurantAdapter) {
        this.restaurantAdapter = restaurantAdapter;
    }

    public RestaurantViewModel(Context context, DataManager dataManager) {
        super(dataManager);
        this.context = context;
    }

    public void searchRestaurantByName(String query) {
        getDataManager().searchRestaurantByName(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RestaurantByNameResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<RestaurantByNameResponse> responses) {
                        titleSearch.set(context.getString(R.string.txt_title_search_result, responses.size()));
                        restaurantAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        titleSearch.set(context.getString(R.string.txt_title_search_result, 0));
                        restaurantAdapter.setItems(new ArrayList<>());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
