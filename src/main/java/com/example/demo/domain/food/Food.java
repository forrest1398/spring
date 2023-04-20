package com.example.demo.domain.food;


public class Food {

    private long id;
    private int price;
    private String name;
    private String contents;
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

    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getContents() {
        return contents;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
    public String getStoreLocation() {
        return storeLocation;
    }
}
