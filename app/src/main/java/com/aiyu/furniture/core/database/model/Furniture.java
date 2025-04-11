package com.aiyu.furniture.core.database.model;

import androidx.annotation.Keep;

enum Category {
    CHAIR,
    SOFA,
    LAMP,
    BED
}

@Keep
public class Furniture {
    private String name;
    private String description;
    private String imageUrl;
    private Category category;
    private String path;

    private Long price;

    private int star;



    public Furniture(String name, String description, String imageUrl, Category category, String path) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.path = path;
    }

    public Furniture(String name, String description, String imageUrl, Category category, String path, Long price, int star) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.path = path;
        this.price = price;
        this.star = star;
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

}
