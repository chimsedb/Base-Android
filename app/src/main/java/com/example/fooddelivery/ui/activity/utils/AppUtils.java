package com.example.fooddelivery.ui.activity.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class AppUtils {
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
