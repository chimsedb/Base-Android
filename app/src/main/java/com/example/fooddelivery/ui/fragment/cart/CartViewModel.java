package com.example.fooddelivery.ui.fragment.cart;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.activity.main.MainViewModel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartViewModel extends BaseViewModel<CartNavigator> {
    public CartViewModel(DataManager dataManager) {
        super(dataManager);
    }

    private CartAdapter cartAdapter;

    public void setCartAdapter(CartAdapter cartAdapter) {
        this.cartAdapter = cartAdapter;
    }

    public void openOrderPlaceScreen() {
        getNavigator().openOrderPlaceScreen();
    }

    public void getCartCategoryFood() {
        Map<Integer, Long> counted = getDataManager().getFoodCart().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < counted.keySet().size(); i++) {
            builder.append(" or ")
                    .append("id = ")
                    .append(counted.keySet().toArray()[i]);
        }
        builder.delete(0, 4);
        String jsonCartCategory = builder.toString();
        if (!TextUtils.isEmpty(jsonCartCategory)) {
            getDataManager().getCartCategoryFood(jsonCartCategory)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<CartCategoryFoodResponse>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<CartCategoryFoodResponse> responses) {
                            cartAdapter.setItems(responses);
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
}
