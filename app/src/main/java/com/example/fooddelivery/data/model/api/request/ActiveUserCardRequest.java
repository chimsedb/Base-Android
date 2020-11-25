package com.example.fooddelivery.data.model.api.request;

public class ActiveUserCardRequest {
    private int active;
    private int id;
    private String user_id;

    public ActiveUserCardRequest(int active, int id, String user_id) {
        this.active = active;
        this.id = id;
        this.user_id = user_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
