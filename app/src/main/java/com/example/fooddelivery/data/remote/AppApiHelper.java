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

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppApiHelper implements ApiHelper {
    private ServiceEndPoint serviceEndPoint;

    @Inject
    public AppApiHelper(ServiceEndPoint serviceEndPoint) {
        this.serviceEndPoint = serviceEndPoint;
    }

    public Observable<List<RestaurantResponse>> getListRestaurantNearYouResponse() {
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

    @Override
    public Observable<UpdateUserInfoResponse> updateUserInfo(UpdateUserInfoRequest request) {
        return serviceEndPoint.updateUserInfo(request);
    }

    @Override
    public Observable<UserCartConfirmResponse> sendUserCartConfirm(List<UserCartConfirmRequest> request) {
        return serviceEndPoint.sendUserCartConfirm(request);
    }

    @Override
    public Observable<PaymentCardResponse> postPaymentCard(PaymentCardRequest request) {
        return serviceEndPoint.postPaymentCard(request);
    }

    @Override
    public Observable<List<UserCardResponse>> getListUserCard(String id) {
        return serviceEndPoint.getListUserCard(id);
    }

    @Override
    public Observable<ActiveUserCardResponse> updateActiveUserCard(ActiveUserCardRequest request) {
        return serviceEndPoint.updateActiveUserCard(request);
    }

    @Override
    public Observable<List<ListFoodTypeResponse>> getListFoodType() {
        return serviceEndPoint.getListFoodType();
    }

    @Override
    public Observable<List<RestaurantResponse>> postRequestFoodType(FoodTypeRequest requests) {
        return serviceEndPoint.postRequestFoodType(requests);
    }

}
