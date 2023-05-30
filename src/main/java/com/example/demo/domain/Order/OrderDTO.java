package com.example.demo.domain.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String address;
    private String status;

    public OrderEntity changeDTOToEntity(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.createOrder(this.address,this.status);
        return orderEntity;
    }

}
