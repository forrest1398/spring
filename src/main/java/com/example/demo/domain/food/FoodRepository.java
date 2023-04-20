package com.example.demo.domain.food;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class FoodRepository {
    
    private static Map<Long, Food> store = new HashMap<>();
    private static long sequence = 0L;

    public Food save(Food food) {
        food.setId(++sequence);
        store.put(food.getId(), food);
        return food;
    }

    public List<Food> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Food> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Food> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    
}
