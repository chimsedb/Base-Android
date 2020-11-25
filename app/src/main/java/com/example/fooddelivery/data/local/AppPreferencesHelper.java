package com.example.fooddelivery.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.fooddelivery.data.model.pref.UserInfo;
import com.example.fooddelivery.di.scope.PreferenceInfo;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_FOOD_CART = "PREF_KEY_FOOD_CART";
    private static final String PREF_KEY_USER_INFO = "PREF_KEY_USER_INFO";
    private static final String PREF_KEY_USER_ADDRESS = "PREF_KEY_USER_ADDRESS";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public List<Integer> getFoodCart() {
        Gson gson = new Gson();
        String json = mPrefs.getString(PREF_KEY_FOOD_CART, "");
        Type type = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> list = gson.fromJson(json, type);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public void addItemFoodCart(int id) {
        Gson gson = new Gson();
        List<Integer> list = getFoodCart();
        list.add(id);
        String json = gson.toJson(list);
        mPrefs.edit().putString(PREF_KEY_FOOD_CART, json).apply();
    }

    @Override
    public void removeItemFoodCart(int id) {
        Gson gson = new Gson();
        List<Integer> list = getFoodCart();
        list.remove(list.indexOf(id));
        String json = gson.toJson(list);
        mPrefs.edit().putString(PREF_KEY_FOOD_CART, json).apply();
    }

    @Override
    public void setUserInfo(GraphResponse response) {
        JSONObject jsonObject = response.getJSONObject();
        Gson gson = new Gson();
        UserInfo userInfo = new UserInfo();
        try {
            userInfo.setId(jsonObject.get("id").toString());
            userInfo.setName(jsonObject.get("name").toString());
            userInfo.setEmail(jsonObject.get("email").toString());
            userInfo.setAvatar(jsonObject.getJSONObject("picture").getJSONObject("data").get("url").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = gson.toJson(userInfo);
        mPrefs.edit().putString(PREF_KEY_USER_INFO, json).apply();
    }

    @Override
    public UserInfo getUserInfo() {
        Gson gson = new Gson();
        String json = mPrefs.getString(PREF_KEY_USER_INFO, "");
        Type type = new TypeToken<UserInfo>() {
        }.getType();
        UserInfo list = gson.fromJson(json, type);
        if (list == null) {
            list = new UserInfo();
        }
        return list;
    }

    @Override
    public void setCurrentAddress(String address) {
        mPrefs.edit().putString(PREF_KEY_USER_ADDRESS, address).apply();
    }

    @Override
    public String getCurrentAddress() {
        return mPrefs.getString(PREF_KEY_USER_ADDRESS, "");
    }

    @Override
    public void removeFoodCart() {
        Gson gson = new Gson();
        List<Integer> list = new ArrayList<>();
        String json = gson.toJson(list);
        mPrefs.edit().putString(PREF_KEY_FOOD_CART, json).apply();
    }
}
