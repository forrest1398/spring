package com.example.demo.domain.food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

    private int price;
    private String name;
    private String comments;
    private String storeLocation;

}
