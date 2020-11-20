package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantNearYouResponse;

import java.util.List;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<List<RestaurantNearYouResponse>> getListRestaurantNearYouResponse();

    Observable<List<FavoriteFoodResponse>> getFavoriteFoodResponse();

    Observable<List<FoodResponse>> getFoodByID(int id);

    Observable<List<FoodOfRestaurantResponse>> getListFoodOfRestaurant(int id);

    Observable<List<CartCategoryFoodResponse>> getCartCategoryFood(String jsonListID);

    Observable<List<RestaurantByNameResponse>> searchRestaurantByName(String name);

    Observable<List<FoodByNameResponse>> searchFoodByName(String name);
}
