package com.example.fooddelivery.data;

import com.example.fooddelivery.data.local.PreferencesHelper;
import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantNearYouResponse;
import com.example.fooddelivery.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    private PreferencesHelper preferencesHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper, PreferencesHelper preferencesHelper) {
        this.apiHelper = apiHelper;
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public Observable<List<RestaurantNearYouResponse>> getListRestaurantNearYouResponse() {
        return apiHelper.getListRestaurantNearYouResponse();
    }

    @Override
    public Observable<List<FavoriteFoodResponse>> getFavoriteFoodResponse() {
        return apiHelper.getFavoriteFoodResponse();
    }

    @Override
    public Observable<List<FoodResponse>> getFoodByID(int id) {
        return apiHelper.getFoodByID(id);
    }

    @Override
    public Observable<List<FoodOfRestaurantResponse>> getListFoodOfRestaurant(int id) {
        return apiHelper.getListFoodOfRestaurant(id);
    }

    @Override
    public Observable<List<CartCategoryFoodResponse>> getCartCategoryFood(String jsonListID) {
        return apiHelper.getCartCategoryFood(jsonListID);
    }

    @Override
    public Observable<List<RestaurantByNameResponse>> searchRestaurantByName(String name) {
        return apiHelper.searchRestaurantByName(name);
    }

    @Override
    public Observable<List<FoodByNameResponse>> searchFoodByName(String name) {
        return apiHelper.searchFoodByName(name);
    }

    @Override
    public List<Integer> getFoodCart() {
        return preferencesHelper.getFoodCart();
    }

    @Override
    public void addFoodCart(int value) {
        preferencesHelper.addFoodCart(value);
    }

    @Override
    public void removeFoodCart() {
        preferencesHelper.removeFoodCart();
    }
}
