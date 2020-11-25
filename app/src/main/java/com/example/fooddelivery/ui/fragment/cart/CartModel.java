package com.example.fooddelivery.ui.fragment.cart;

public class CartModel {
    private int id;
    private long count;

    public CartModel(int id, long count) {
        this.id = id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
