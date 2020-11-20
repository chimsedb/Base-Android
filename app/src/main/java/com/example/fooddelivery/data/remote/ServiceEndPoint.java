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
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceEndPoint {
    @GET("/restaurants/restaurantsNearYou")
    Observable<List<RestaurantNearYouResponse>> getListRestaurantNearYouResponse();

    @GET("/foods/favoriteFood")
    Observable<List<FavoriteFoodResponse>> getFavoriteFoodResponse();

    @GET("/foods")
    Observable<List<FoodResponse>> getFoodByID(@Query("id") int id);

    @GET("/foods/foodOfRestaurant")
    Observable<List<FoodOfRestaurantResponse>> getListFoodOfRestaurant(@Query("id") int id);

    @GET("/cart/categoryFood")
    Observable<List<CartCategoryFoodResponse>> getCartCategoryFood(@Query("listID") String jsonListID);

    @GET("/restaurants/restaurantByName")
    Observable<List<RestaurantByNameResponse>> searchRestaurantByName(@Query("name") String name);

    @GET("/foods/foodByName")
    Observable<List<FoodByNameResponse>> searchFoodByName(@Query("name") String name);
}
