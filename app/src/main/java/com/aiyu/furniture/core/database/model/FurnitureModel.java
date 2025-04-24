package com.aiyu.furniture.core.database.model;

import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class FurnitureModel implements Serializable {
    private String name;
    private String description;
    private String imageUrl;
    private Category category;
    private String path;

    private Long price;

    private int star;
    private int imageRes;


    public FurnitureModel(String name, String description, String imageUrl, Category category, String path, Long price, int star) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.path = path;
        this.price = price;
        this.star = star;
        this.imageRes = 0;
    }

    public FurnitureModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

}
