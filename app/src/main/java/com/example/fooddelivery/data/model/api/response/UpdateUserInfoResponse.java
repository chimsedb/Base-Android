package com.example.fooddelivery.data.model.api.response;

public class UpdateUserInfoResponse {
    private String msg;

    public UpdateUserInfoResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
