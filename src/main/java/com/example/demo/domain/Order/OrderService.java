package com.example.demo.domain.Order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

}
