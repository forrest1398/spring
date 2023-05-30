package com.example.demo.domain.Order;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ORDERS")
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUS")
    private String status;

    public void createOrder(String address,String status){
        this.address=address;
        this.status=status;
    }

    public void updateOrder(String address,String status){
        this.address=address;
        this.status=status;
    }

    public OrderDTO changeEntityToDTO(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setAddress(this.getAddress());
        orderDTO.setStatus(this.getStatus());
        return orderDTO;
    }

}
