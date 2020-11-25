package com.example.fooddelivery.data.model.api.request;

public class UpdateUserInfoRequest {
    private String id;
    private String name;
    private String email;
    private String avatar;
    private String address;

    public UpdateUserInfoRequest(String id, String name, String email, String avatar, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
