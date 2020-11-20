package com.example.fooddelivery.data.model.api.response;

public class CartCategoryFoodResponse {
    public int id;
    public int food_type_id;
    public String food_name;
    public String price;
    public int discount;
    public String thumbnail;
    public int res_id;

    public CartCategoryFoodResponse(int id, int food_type_id, String food_name, String price, int discount, String thumbnail, int res_id) {
        this.id = id;
        this.food_type_id = food_type_id;
        this.food_name = food_name;
        this.price = price;
        this.discount = discount;
        this.thumbnail = thumbnail;
        this.res_id = res_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFood_type_id() {
        return food_type_id;
    }

    public void setFood_type_id(int food_type_id) {
        this.food_type_id = food_type_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
}
