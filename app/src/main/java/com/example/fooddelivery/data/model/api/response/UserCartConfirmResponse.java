package com.example.fooddelivery.data.model.api.response;

public class UserCartConfirmResponse {
    private String msg;

    public UserCartConfirmResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
