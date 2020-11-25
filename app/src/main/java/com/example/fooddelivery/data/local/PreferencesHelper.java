package com.example.fooddelivery.data.local;

import com.example.fooddelivery.data.model.pref.UserInfo;
import com.facebook.GraphResponse;

import java.util.List;

public interface PreferencesHelper {
    List<Integer> getFoodCart();

    void addItemFoodCart(int value);

    void removeFoodCart();

    void removeItemFoodCart(int id);

    void setUserInfo(GraphResponse response);

    UserInfo getUserInfo();

    void setCurrentAddress(String address);

    String getCurrentAddress();
}
