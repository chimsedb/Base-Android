package com.example.fooddelivery.ui.fragment.home.item_view_model;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;

public class FavoriteFoodItemViewModel {
    public ObservableField<String> image = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> discount = new ObservableField<>("");

    public FavoriteFoodItemViewModel(FavoriteFoodResponse response) {
        image.set(response.getThumbnail());
        name.set(response.getFood_name());
        StringBuilder builderDiscount = new StringBuilder();
        builderDiscount.append("Giảm ").append(response.getDiscount())
                .append("%");
        discount.set(builderDiscount.toString());
    }
}
