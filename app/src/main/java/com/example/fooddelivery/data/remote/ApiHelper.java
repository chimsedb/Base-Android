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

public interface ApiHelper {
    Observable<List<RestaurantResponse>> getListRestaurantNearYouResponse();

    Observable<List<FavoriteFoodResponse>> getFavoriteFoodResponse();

    Observable<List<FoodResponse>> getFoodByID(int id);

    Observable<List<FoodOfRestaurantResponse>> getListFoodOfRestaurant(int id);

    Observable<List<CartCategoryFoodResponse>> getCartCategoryFood(String jsonListID);

    Observable<List<RestaurantByNameResponse>> searchRestaurantByName(String name);

    Observable<List<FoodByNameResponse>> searchFoodByName(String name);

    Observable<UpdateUserInfoResponse> updateUserInfo(UpdateUserInfoRequest request);

    Observable<UserCartConfirmResponse> sendUserCartConfirm(List<UserCartConfirmRequest> request);

    Observable<PaymentCardResponse> postPaymentCard(PaymentCardRequest request);

    Observable<List<UserCardResponse>> getListUserCard(String id);

    Observable<ActiveUserCardResponse> updateActiveUserCard(ActiveUserCardRequest request);

    Observable<List<ListFoodTypeResponse>> getListFoodType();

    Observable<List<RestaurantResponse>> postRequestFoodType(FoodTypeRequest requests);
}
