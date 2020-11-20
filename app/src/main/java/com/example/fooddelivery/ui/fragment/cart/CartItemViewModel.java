package com.example.fooddelivery.ui.fragment.cart;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

import okhttp3.Interceptor;

public class CartItemViewModel {
    public ObservableField<String> thumbnail = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> price = new ObservableField<>("");
    public ObservableField<String> total = new ObservableField<>("");

    private int totalItem = 1;
    private int priceItem;

    public CartItemViewModel(CartCategoryFoodResponse response) {
        thumbnail.set(response.getThumbnail());
        name.set(response.getFood_name());
        priceItem = Integer.parseInt(response.getPrice());
        price.set(StringUtils.getPriceVND(priceItem * totalItem));
        total.set(String.valueOf(totalItem));
    }

    public void subtract() {
        totalItem -= 1;
        if (totalItem <= 0) {
            totalItem = 0;
        }
        total.set(String.valueOf(totalItem));
        price.set(StringUtils.getPriceVND(priceItem * totalItem));
    }

    public void add() {
        totalItem += 1;
        total.set(String.valueOf(totalItem));
        price.set(StringUtils.getPriceVND(priceItem * totalItem));
    }
}
