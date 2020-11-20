package com.example.fooddelivery.ui.fragment.search.dishs;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DishViewModel extends BaseViewModel<DishNavigator> {
    private final Context context;
    public ObservableField<String> titleSearch = new ObservableField<>();

    private DishAdapter dishAdapter;

    public void setRestaurantAdapter(DishAdapter dishAdapter) {
        this.dishAdapter = dishAdapter;
    }


    public DishViewModel(Context context,DataManager dataManager) {
        super(dataManager);
        this.context = context;
    }

    public void searchFoodByName(String query) {
        getDataManager().searchFoodByName(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FoodByNameResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<FoodByNameResponse> responses) {
                        titleSearch.set(context.getString(R.string.txt_title_search_result, responses.size()));
                        dishAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        titleSearch.set(context.getString(R.string.txt_title_search_result, 0));
                        dishAdapter.setItems(new ArrayList<>());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
