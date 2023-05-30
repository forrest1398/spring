package com.example.demo.domain.Order;


import com.example.demo.domain.food.FoodDTO;
import com.example.demo.domain.food.FoodEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final EntityManager em;
    public OrderRepository(EntityManager em) {
        this.em = em;
    }


    public void save(OrderDTO orderDTO){
        OrderEntity orderEntity = orderDTO.changeDTOToEntity();
        em.persist(orderEntity);
    }

    public void addOrderedFood(String orderId,String foodId){
        OrderedFoodEntity orderedFoodEntity = new OrderedFoodEntity();
        orderedFoodEntity.updateOrderedFood(orderId,foodId);
        em.persist(orderedFoodEntity);
    }

    // SQL을 활용해서 주문된 음식을 찾는 방법
    public List<FoodDTO> findFoodsInOrder(String orderId){

        String query = "select f from FoodEntity f join OrderedFoodEntity o"
                +" where o.orderId = "+orderId
                +" and o.foodId = f.id";
        List<FoodEntity> allEntities =  em.createQuery(query,FoodEntity.class).getResultList();

        List<FoodDTO> result = new ArrayList<>();
        for(FoodEntity foodEntity : allEntities){
            result.add(foodEntity.changeEntityToDTO());
        }
        return result;

    }

    //todo
//    //OrderedFoodEntity의 필드를 활용해서 주문된 음식을 찾는 방법
//    public List<FoodDTO> findFoodsInOrderV2(String orderId) {
//    }

}
