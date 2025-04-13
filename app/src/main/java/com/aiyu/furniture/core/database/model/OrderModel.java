package com.aiyu.furniture.core.database.model;


public class OrderModel {
    private FurnitureModel furniture;
    private Long orderedAt;
    private String path;
    private double price;
    private OrderStates orderState;

    public OrderModel() {
    }

    public OrderModel(FurnitureModel furniture, Long orderedAt, String path, Double price) {
        this.furniture = furniture;
        this.orderedAt = orderedAt;
        this.path = path;
        this.price = price;
        this.orderState = OrderStates.values()[(int) (Math.random() * OrderStates.values().length)];
    }

    public FurnitureModel getFurniture() {
        return furniture;
    }

    public Long getOrderedAt() {
        return orderedAt;
    }

    public String getPath() {
        return path;
    }

    public OrderStates getOrderState() {
        return orderState;
    }

    public void setFurniture(FurnitureModel furniture) {
        this.furniture = furniture;
    }

    public void setOrderedAt(Long orderedAt) {
        this.orderedAt = orderedAt;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getPrice() {
        return price;
    }
}
