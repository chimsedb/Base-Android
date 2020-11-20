package com.example.fooddelivery.ui.fragment.suggestion;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

public class SuggestionItemViewModel {
    public ObservableField<String> image = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> star = new ObservableField<>("");
    public ObservableField<String> price = new ObservableField<>("");
    public ObservableField<String> discount = new ObservableField<>("");

    public SuggestionItemViewModel(FavoriteFoodResponse response) {
        image.set(response.getThumbnail());
        name.set(response.getFood_name());
//        star.set(response.get());
        price.set(StringUtils.getPriceVND(response.getPrice()));
        StringBuilder builderDiscount = new StringBuilder();
        builderDiscount.append("Giảm ").append(response.getDiscount())
                .append("%");
        discount.set(builderDiscount.toString());
    }
}
