package com.example.fooddelivery.data.model.api.response;

public class ListFoodTypeResponse {
    private int id;
    private String food_type_name;

    public ListFoodTypeResponse(int id, String food_type_name) {
        this.id = id;
        this.food_type_name = food_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_type_name() {
        return food_type_name;
    }

    public void setFood_type_name(String food_type_name) {
        this.food_type_name = food_type_name;
    }
}
