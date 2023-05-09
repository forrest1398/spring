package com.example.demo.domain.food;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

    private int price;
    private String name;
    private String comments;
    private String storeLocation;

    // DTO -> Entity 변환 함수
    public FoodEntity changeDTOToEntity(){
        FoodEntity foodEntity = new FoodEntity();
                foodEntity.createFoodEntity(
                this.price,
                this.name,
                this.comments,
                this.storeLocation);
        return foodEntity;
    }

}
