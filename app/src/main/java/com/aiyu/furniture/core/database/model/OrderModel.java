package com.aiyu.furniture.core.database.model;

import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class OrderModel implements Serializable {
    private FurnitureModel furniture;
    private double price;
    private OrderStates orderState;
    private AddressModel address;
    private Long orderedAt;
    private String path;

    public OrderModel(FurnitureModel furniture, double price, OrderStates orderState, AddressModel address, Long orderedAt, String path) {
        this.furniture = furniture;
        this.price = price;
        this.orderState = orderState;
        this.address = address;
        this.orderedAt = orderedAt;
        this.path = path;
    }

    public OrderModel() {
    }

    public FurnitureModel getFurniture() {
        return furniture;
    }

    public void setFurniture(FurnitureModel furniture) {
        this.furniture = furniture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStates getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderStates orderState) {
        this.orderState = orderState;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public Long getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Long orderedAt) {
        this.orderedAt = orderedAt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
