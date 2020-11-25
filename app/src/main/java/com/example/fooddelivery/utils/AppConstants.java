package com.example.fooddelivery.utils;

public class AppConstants {
    public static final long NULL_INDEX = -1L;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    public static final String FOOD_ID = "FOOD_ID";
    public static final String RESTAURANT_ID = "RESTAURANT_ID";
    public static final String BUNDLE_FROM_CART_FRAGMENT = "BUNDLE_FROM_CART_FRAGMENT";
    public static final String PREF_NAME = "food_pref";

    public enum CartType {
        ADD, REMOVE
    }
}
