package com.example.demo.domain.Order;


import com.example.demo.domain.food.FoodDTO;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private String address;
    private String status;

    public OrderEntity changeDTOToEntity(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAddress(this.getAddress());
        orderEntity.setStatus(this.getStatus());
        return orderEntity;
    }

}
