package com.example.demo.domain.food;

import jakarta.persistence.*;

@Entity
@Table(name = "FOOD")
public class FoodEntity {

    @Id
    private long id;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "STORELOCATION")
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
