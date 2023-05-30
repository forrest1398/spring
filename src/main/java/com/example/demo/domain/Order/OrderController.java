package com.example.demo.domain.Order;
import com.example.demo.domain.food.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("")
    @ResponseBody
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrderEntity(orderDTO);
        return orderDTO;
    }

    @GetMapping("{orderId}/{foodId}")
    public void addFoodToOrder(@PathVariable("orderId") String orderId,@PathVariable("foodId")String foodId){
        orderService.addOrderedFood(orderId,foodId);
    }

    @GetMapping("{orderId}")
    @ResponseBody
    public List<FoodDTO> showdFoodsInOrder(@PathVariable("orderId") String orderId){
        return orderService.findFoodsInOrder(orderId);
    }


}
