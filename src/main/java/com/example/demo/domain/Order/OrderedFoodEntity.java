package com.example.demo.domain.Order;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERED_FOOD")
public class OrderedFoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FOOD_ID")
    private String foodId;

    @Column(name = "ORDER_ID")
    private String orderId;

}
