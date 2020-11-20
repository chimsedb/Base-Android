package com.example.fooddelivery.ui.activity.utils;

public class StringUtils {
    public static String token = "hello";

    public static String getPriceVND(String s) {
        return s + ",000đ";
    }

    public static String getPriceVND(Integer s) {
        return s + ",000đ";
    }
}
