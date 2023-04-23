package com.example.demo.domain.food;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodForm {
    private long id;
    private int price;
    private String name;
    private String comments;
    private String storeLocation;

}