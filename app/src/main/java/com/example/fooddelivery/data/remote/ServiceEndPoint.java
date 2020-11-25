package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.request.ActiveUserCardRequest;
import com.example.fooddelivery.data.model.api.request.FoodTypeRequest;
import com.example.fooddelivery.data.model.api.request.PaymentCardRequest;
import com.example.fooddelivery.data.model.api.request.UpdateUserInfoRequest;
import com.example.fooddelivery.data.model.api.request.UserCartConfirmRequest;
import com.example.fooddelivery.data.model.api.response.ActiveUserCardResponse;
import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.data.model.api.response.ListFoodTypeResponse;
import com.example.fooddelivery.data.model.api.response.PaymentCardResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.data.model.api.response.RestaurantResponse;
import com.example.fooddelivery.data.model.api.response.UpdateUserInfoResponse;
import com.example.fooddelivery.data.model.api.response.UserCardResponse;
import com.example.fooddelivery.data.model.api.response.UserCartConfirmResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ServiceEndPoint {
    @GET("/restaurants/restaurantsNearYou")
    Observable<List<RestaurantResponse>> getListRestaurantNearYouResponse();

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

    @POST("/user/updateUserInfo")
    Observable<UpdateUserInfoResponse> updateUserInfo(@Body UpdateUserInfoRequest request);

    @POST("/cart/userCartConfirm")
    Observable<UserCartConfirmResponse> sendUserCartConfirm(@Body List<UserCartConfirmRequest> request);

    @POST("/payment/addUserCard")
    Observable<PaymentCardResponse> postPaymentCard(@Body PaymentCardRequest request);

    @GET("/payment/getUserCard")
    Observable<List<UserCardResponse>> getListUserCard(@Query("user_id") String id);

    @PUT("/payment/updateActiveUserCard")
    Observable<ActiveUserCardResponse> updateActiveUserCard(@Body ActiveUserCardRequest request);

    @GET("/foodType/listFoodType")
    Observable<List<ListFoodTypeResponse>> getListFoodType();

    @POST("/foods/listFoodType")
    Observable<List<RestaurantResponse>> postRequestFoodType(@Body FoodTypeRequest requests);
}
