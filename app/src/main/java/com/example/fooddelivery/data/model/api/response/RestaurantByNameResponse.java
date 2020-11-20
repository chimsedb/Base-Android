package com.example.fooddelivery.data.model.api.response;

public class RestaurantByNameResponse {
    private int id ;
    private String res_name ;
    private String address ;
    private String banner ;
    private double rate;

    public RestaurantByNameResponse(int id, String res_name, String address, String banner, double rate) {
        this.id = id;
        this.res_name = res_name;
        this.address = address;
        this.banner = banner;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
