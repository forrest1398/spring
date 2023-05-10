package com.example.demo.domain.food;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "FOOD")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "STORELOCATION")
    private String storeLocation;


    public void createFoodEntity(int price , String name , String comments , String storeLocation){
        this.price=price;
        this.name=name;
        this.comments=comments;
        this.storeLocation=storeLocation;
    }

    public void updateFoodEntity(int price , String name , String comments , String storeLocation){
        this.price=price;
        this.name=name;
        this.comments=comments;
        this.storeLocation=storeLocation;
    }

    public FoodDTO changeEntityToDTO(){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setPrice(this.getPrice());
        foodDTO.setName(this.getName());
        foodDTO.setComments(this.getComments());
        foodDTO.setStoreLocation(this.getStoreLocation());
        return foodDTO;
    }

}
