package com.example.fooddelivery.ui.fragment.filter_sort;

import com.example.fooddelivery.data.model.api.response.RestaurantResponse;

import java.util.List;

public interface FilterNavigator {
    void updateRestaurantFilter(List<RestaurantResponse> response);

    void closeDialog();
}
