package com.example.fooddelivery.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fooddelivery.di.scope.PreferenceInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_FOOD_CART = "PREF_KEY_FOOD_CART";

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
    public void addFoodCart(int id) {
        Gson gson = new Gson();
        List<Integer> list = getFoodCart();
        list.add(id);
        String json = gson.toJson(list);
        mPrefs.edit().putString(PREF_KEY_FOOD_CART, json).apply();
    }

    @Override
    public void removeFoodCart() {
        Gson gson = new Gson();
        List<Integer> list = new ArrayList<>();
        String json = gson.toJson(list);
        mPrefs.edit().putString(PREF_KEY_FOOD_CART, json).apply();
    }
}
