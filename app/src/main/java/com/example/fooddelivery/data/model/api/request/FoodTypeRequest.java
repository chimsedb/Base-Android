package com.example.fooddelivery.data.model.api.request;

public class FoodTypeRequest {
    private String string_food_type_name;

    public FoodTypeRequest(String string_food_type_name) {
        this.string_food_type_name = string_food_type_name;
    }

    public String getString_food_type_name() {
        return string_food_type_name;
    }

    public void setString_food_type_name(String string_food_type_name) {
        this.string_food_type_name = string_food_type_name;
    }
}
