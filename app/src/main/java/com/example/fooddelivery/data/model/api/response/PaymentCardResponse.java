package com.example.fooddelivery.data.model.api.response;

public class PaymentCardResponse {
    private String msg;

    public PaymentCardResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
