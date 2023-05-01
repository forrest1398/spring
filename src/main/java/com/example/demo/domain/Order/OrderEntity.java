package com.example.demo.domain.Order;

import com.example.demo.domain.food.FoodDTO;
import com.example.demo.domain.food.FoodEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Setter
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "STATUS")
    private String status;

    public OrderDTO changeEntityToDTO(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setAdress(this.getAdress());
        orderDTO.setStatus(this.getStatus());
        return orderDTO;
    }

}
