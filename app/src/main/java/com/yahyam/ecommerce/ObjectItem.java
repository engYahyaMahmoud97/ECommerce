package com.yahyam.ecommerce;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ObjectItem implements Serializable {
    private String id;
    private String name;
    private String price;
    private String image;
    private boolean isLike;

    public ObjectItem(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
