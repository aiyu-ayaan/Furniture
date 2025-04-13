package com.aiyu.furniture.core.database.model;

import androidx.annotation.Keep;

@Keep
public class CartModel {
    private FurnitureModel items;
    private int quantity;

    public CartModel() {
    }

    public CartModel(FurnitureModel items, int quantity) {
        this.items = items;
        this.quantity = quantity;
    }

    public FurnitureModel getItems() {
        return items;
    }

    public void setItems(FurnitureModel items) {
        this.items = items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
