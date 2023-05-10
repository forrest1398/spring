package com.example.demo.domain.Order;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ORDERED_FOOD")
@Getter
public class OrderedFoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FOOD_ID")
    private String foodId;

    @Column(name = "ORDER_ID")
    private String orderId;

    public void updateOrderedFood(String orderId , String foodId){
        this.orderId=orderId;
        this.foodId=foodId;
    }

}
