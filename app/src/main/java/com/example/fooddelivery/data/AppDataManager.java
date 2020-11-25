package com.example.fooddelivery.data;

import com.example.fooddelivery.data.local.PreferencesHelper;
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
import com.example.fooddelivery.data.model.pref.UserInfo;
import com.example.fooddelivery.data.remote.ApiHelper;
import com.facebook.GraphResponse;

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
    public Observable<List<RestaurantResponse>> getListRestaurantNearYouResponse() {
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
    public Observable<UpdateUserInfoResponse> updateUserInfo(UpdateUserInfoRequest request) {
        return apiHelper.updateUserInfo(request);
    }

    @Override
    public Observable<UserCartConfirmResponse> sendUserCartConfirm(List<UserCartConfirmRequest> request) {
        return apiHelper.sendUserCartConfirm(request);
    }

    @Override
    public Observable<PaymentCardResponse> postPaymentCard(PaymentCardRequest request) {
        return apiHelper.postPaymentCard(request);
    }

    @Override
    public Observable<List<UserCardResponse>> getListUserCard(String id) {
        return apiHelper.getListUserCard(id);
    }

    @Override
    public Observable<ActiveUserCardResponse> updateActiveUserCard(ActiveUserCardRequest request) {
        return apiHelper.updateActiveUserCard(request);
    }

    @Override
    public Observable<List<ListFoodTypeResponse>> getListFoodType() {
        return apiHelper.getListFoodType();
    }

    @Override
    public Observable<List<RestaurantResponse>> postRequestFoodType(FoodTypeRequest requests) {
        return apiHelper.postRequestFoodType(requests);
    }

    @Override
    public List<Integer> getFoodCart() {
        return preferencesHelper.getFoodCart();
    }

    @Override
    public void addItemFoodCart(int value) {
        preferencesHelper.addItemFoodCart(value);
    }

    @Override
    public void removeFoodCart() {
        preferencesHelper.removeFoodCart();
    }

    @Override
    public void removeItemFoodCart(int id) {
        preferencesHelper.removeItemFoodCart(id);
    }

    @Override
    public void setUserInfo(GraphResponse response) {
        preferencesHelper.setUserInfo(response);
    }

    @Override
    public UserInfo getUserInfo() {
        return preferencesHelper.getUserInfo();
    }

    @Override
    public void setCurrentAddress(String address) {
        preferencesHelper.setCurrentAddress(address);
    }

    @Override
    public String getCurrentAddress() {
        return preferencesHelper.getCurrentAddress();
    }
}
