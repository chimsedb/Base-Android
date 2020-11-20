package com.example.fooddelivery.ui.fragment.suggestion;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SuggestionViewModel extends BaseViewModel<SuggestionNavigator> {
    public ObservableField<String> image = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> discount = new ObservableField<>();

    private SuggestionAdapter suggestionAdapter;

    public void setSuggestionAdapter(SuggestionAdapter suggestionAdapter) {
        this.suggestionAdapter = suggestionAdapter;
    }

    public SuggestionViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void getListFavoriteFood() {
        getDataManager().getFavoriteFoodResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<FavoriteFoodResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<FavoriteFoodResponse> responses) {
                        suggestionAdapter.setItems(responses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getFavoriteFood(int foodId) {
        getDataManager().getFoodByID(foodId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<FoodResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<FoodResponse> responses) {
                        FoodResponse response = responses.get(0);
                        image.set(response.getThumbnail());
                        name.set(response.getFood_name());
                        price.set(StringUtils.getPriceVND(response.getPrice()));
                        StringBuilder builderDiscount = new StringBuilder();
                        builderDiscount.append("Giảm ").append(response.getDiscount())
                                .append("%");
                        discount.set(builderDiscount.toString());
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
