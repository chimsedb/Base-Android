package com.example.fooddelivery.data.model.api.request;

public class UserCartConfirmRequest {
    private int res_id;
    private int food_id;
    private String user_id;
    private String food_name;
    private int count;
    private int price;
    private int discount;
    private long time_order;

    public UserCartConfirmRequest(int res_id, int food_id, String user_id, String food_name, int count, int price, int discount, long time_order) {
        this.res_id = res_id;
        this.food_id = food_id;
        this.user_id = user_id;
        this.food_name = food_name;
        this.count = count;
        this.price = price;
        this.discount = discount;
        this.time_order = time_order;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getTime_order() {
        return time_order;
    }

    public void setTime_order(long time_order) {
        this.time_order = time_order;
    }
}
