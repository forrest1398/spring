package com.example.demo.domain.Order;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final EntityManager em;
    @Autowired
    public OrderRepository(EntityManager em) {
        this.em = em;
    }



}
