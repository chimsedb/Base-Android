package com.example.fooddelivery.ui.fragment.search.restaurant;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;

public class RestaurantItemViewModel {
    public ObservableField<String> url = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> address = new ObservableField<>("");

    public RestaurantItemViewModel(RestaurantByNameResponse response) {
        url.set(response.getBanner());
        name.set(response.getRes_name());
        address.set(response.getAddress());
    }
}
