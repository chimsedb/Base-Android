package com.example.fooddelivery.data.model.api.request;

public class PaymentCardRequest {
    private String user_id;
    private String card_name;
    private String date_valid;
    private String cvv;
    private String card_number;
    private int active;

    public PaymentCardRequest(String user_id, String card_name, String date_valid, String cvv, String card_number, int active) {
        this.user_id = user_id;
        this.card_name = card_name;
        this.date_valid = date_valid;
        this.cvv = cvv;
        this.card_number = card_number;
        this.active = active;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getDate_valid() {
        return date_valid;
    }

    public void setDate_valid(String date_valid) {
        this.date_valid = date_valid;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
