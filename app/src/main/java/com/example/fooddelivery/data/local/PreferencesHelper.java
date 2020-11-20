package com.example.fooddelivery.data.local;

import java.util.List;

public interface PreferencesHelper {
    List<Integer> getFoodCart();

    void addFoodCart(int value);

    void removeFoodCart();
}
