package com.example.demo.domain.food;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class FoodRepository {

    private final EntityManager em;

    public FoodRepository(EntityManager em) {
        this.em = em;
    }

    public FoodEntity save(FoodEntity foodentity) {
        em.persist(foodentity);
        return foodentity;
    }

    public Optional<FoodEntity> findById(Long id) {
        FoodEntity foodentity =  em.find(FoodEntity.class,id);
        return Optional.ofNullable(foodentity);
    }

    public Optional<FoodEntity> findByName(String name) {
        List<FoodEntity> result = em.createQuery("select m from FoodEntity m where m.name =:name", FoodEntity.class).setParameter("name",name)
                .getResultList();
        return result.stream().findAny();
    }

    public List<FoodEntity> findAll() {
        List<FoodEntity> result = em.createQuery("select f from FoodEntity f", FoodEntity.class).getResultList();
        return result;
    }

}
