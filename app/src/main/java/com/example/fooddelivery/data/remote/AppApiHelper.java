package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantNearYouResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppApiHelper implements ApiHelper {
    private ServiceEndPoint serviceEndPoint;

    @Inject
    public AppApiHelper(ServiceEndPoint serviceEndPoint) {
        this.serviceEndPoint = serviceEndPoint;
    }

    public Observable<List<RestaurantNearYouResponse>> getListRestaurantNearYouResponse() {
        return serviceEndPoint.getListRestaurantNearYouResponse();
    }

    public Observable<List<FavoriteFoodResponse>> getFavoriteFoodResponse() {
        return serviceEndPoint.getFavoriteFoodResponse();
    }

    @Override
    public Observable<List<FoodResponse>> getFoodByID(int id) {
        return serviceEndPoint.getFoodByID(id);
    }

    @Override
    public Observable<List<FoodOfRestaurantResponse>> getListFoodOfRestaurant(int id) {
        return serviceEndPoint.getListFoodOfRestaurant(id);
    }

    @Override
    public Observable<List<CartCategoryFoodResponse>> getCartCategoryFood(String jsonListID) {
        return serviceEndPoint.getCartCategoryFood(jsonListID);
    }

    @Override
    public Observable<List<RestaurantByNameResponse>> searchRestaurantByName(String name) {
        return serviceEndPoint.searchRestaurantByName(name);
    }

    @Override
    public Observable<List<FoodByNameResponse>> searchFoodByName(String name) {
        return serviceEndPoint.searchFoodByName(name);
    }

}
