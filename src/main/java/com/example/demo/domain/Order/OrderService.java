package com.example.demo.domain.Order;

import com.example.demo.domain.food.FoodDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    public void createOrderEntity(OrderDTO orderDTO){
        orderRepository.save(orderDTO);
    }

    public void addOrderedFood(String orderId,String foodId){
        orderRepository.addOrderedFood(orderId,foodId);
    }

    public List<FoodDTO> findFoodsInOrder(String orderId){
        return orderRepository.findFoodsInOrder(orderId);
    }

}
