package com.example.demo.domain.food;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "FOOD")
public class FoodEntity {

    @Id
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

}
