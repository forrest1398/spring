package com.example.demo.domain.food;


public class FoodForm {

    private long id;
    private int price;
    private String name;
    private String comments;
    private String storeLocation;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getComments() {
        return comments;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
    public String getStoreLocation() {
        return storeLocation;
    }
}
