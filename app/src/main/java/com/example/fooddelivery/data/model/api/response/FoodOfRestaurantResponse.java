package com.example.fooddelivery.data.model.api.response;

public class FoodOfRestaurantResponse {
    private int id ;
    private String food_name ;
    private String price ;
    private int discount ;
    private String thumbnail;
    private String res_name ;
    private String address;
    private double rate;
    private int restaurant_id;

    public FoodOfRestaurantResponse(int id, String food_name, String price,
                                    int discount, String thumbnail, String res_name, String address, double rate, int restaurant_id) {
        this.id = id;
        this.food_name = food_name;
        this.price = price;
        this.discount = discount;
        this.thumbnail = thumbnail;
        this.res_name = res_name;
        this.address = address;
        this.rate = rate;
        this.restaurant_id = restaurant_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
