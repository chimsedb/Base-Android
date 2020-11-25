package com.example.fooddelivery.ui.fragment.home.item_view_model;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.RestaurantResponse;

public class RestaurantItemViewModel {
    public ObservableField<String> thumbnail = new ObservableField<>("");
    public ObservableField<String> restaurantName = new ObservableField<>("");
    public ObservableField<String> address = new ObservableField<>("");
    public ObservableField<String> rate = new ObservableField<>("");
    public ObservableField<String> timeDelivery = new ObservableField<>("");

    public RestaurantItemViewModel(RestaurantResponse response) {
        thumbnail.set(response.getBanner());
        address.set(response.getAddress());
        rate.set(String.valueOf(response.getRate()));
        restaurantName.set(response.getName());
    }
}
