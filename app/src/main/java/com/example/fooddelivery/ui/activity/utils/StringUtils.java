package com.example.fooddelivery.ui.activity.utils;

public class StringUtils {
    public static String token = "hello";

    public static String getPriceVND(String s) {
        return s + ",000đ";
    }

    public static String getPriceVND(Integer s) {
        return s + ",000đ";
    }

    public static String formatCardPayment(String s) {
        String result = s.substring(0, 4) + "-" +
                s.substring(4, 8) + "-" +
                s.substring(8, 12) + "-" + s.substring(12);
        return result;
    }
}
