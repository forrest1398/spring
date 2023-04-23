package com.example.demo.domain.food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodDTO {

    private int price;
    private String name;
    private String comments;
    private String storeLocation;

}
