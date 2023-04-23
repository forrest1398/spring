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

    // Entity -> DTO 변환 함수
    public FoodDTO EntityToDTO(FoodEntity foodEntity){
        FoodDTO foodDTO = FoodDTO.builder()
                .price(foodEntity.getPrice())
                .name(foodEntity.getName())
                .comments(foodEntity.getComments())
                .storeLocation(foodEntity.getStoreLocation()).build();
        return foodDTO;
    }

    public void save(long id,FoodDTO foodDTO) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(id);
        foodEntity.setPrice(foodDTO.getPrice());
        foodEntity.setName(foodDTO.getName());
        foodEntity.setComments(foodDTO.getComments());
        foodEntity.setStoreLocation(foodDTO.getStoreLocation());
        em.persist(foodEntity);
    }

    public Optional<FoodEntity> findById(Long id) {
        FoodEntity foodentity =  em.find(FoodEntity.class,id);
        return Optional.ofNullable(foodentity);
    }

    public FoodDTO findByName(String name) {
        List<FoodEntity> result = em.createQuery("select m from FoodEntity m where m.name =:name", FoodEntity.class).setParameter("name",name)
                .getResultList();
        if(result.stream().findAny().isEmpty())return null;
        else return EntityToDTO(result.get(0));
    }

    public List<FoodDTO> findAll() {
        List<FoodEntity> AllEntity = em.createQuery("select f from FoodEntity f", FoodEntity.class).getResultList();
        //Entity -> Dto 변환
        List<FoodDTO> result = new ArrayList<>();
        for(FoodEntity foodEntity : AllEntity){
            result.add(EntityToDTO(foodEntity));
        }
        return result;
    }

}
