package com.example.demo.domain.food;

import jakarta.persistence.Entity;
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
    public FoodDTO changeEntityToDTO(FoodEntity foodEntity){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setPrice(foodEntity.getPrice());
        foodDTO.setName(foodEntity.getName());
        foodDTO.setComments(foodEntity.getComments());
        foodDTO.setStoreLocation(foodEntity.getStoreLocation());
        return foodDTO;
    }

    // DTO -> Entity 변환 함수
    public FoodEntity changeDTOTOEntity(FoodDTO foodDTO){
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setPrice(foodDTO.getPrice());
        foodEntity.setName(foodDTO.getName());
        foodEntity.setComments(foodDTO.getComments());
        foodEntity.setStoreLocation(foodDTO.getStoreLocation());
        return foodEntity;
    }

    public void save(FoodDTO foodDTO) {
        FoodEntity foodEntity = changeDTOTOEntity(foodDTO);
        em.persist(foodEntity);
    }

    public void remove(String name){
        List<FoodEntity> result = em.createQuery("select m from FoodEntity m where m.name =:name", FoodEntity.class).setParameter("name",name)
                .getResultList();
        if(!result.stream().findAny().isEmpty())
            em.remove(result.get(0));
    }

    public void update(FoodDTO foodDTO){
        List<FoodEntity> result = em.createQuery("select m from FoodEntity m where m.name =:name", FoodEntity.class).setParameter("name",foodDTO.getName())
                .getResultList();
        if(!result.stream().findAny().isEmpty()) {
            FoodEntity target = result.get(0);
            target.setPrice(foodDTO.getPrice());
            target.setName(foodDTO.getName());
            target.setComments(foodDTO.getComments());
            target.setStoreLocation(foodDTO.getStoreLocation());
            em.merge(target);
        }
    }

    public void updatev2(Long id,FoodDTO foodDTO){
        FoodEntity target = findEntityById(id);
        target.setPrice(foodDTO.getPrice());
        target.setName(foodDTO.getName());
        target.setComments(foodDTO.getComments());
        target.setStoreLocation(foodDTO.getStoreLocation());
        em.merge(target);
    }

    public Optional<FoodDTO> findDTOById(Long id) {
        FoodEntity foodentity =  em.find(FoodEntity.class,id);
        FoodDTO foodDTO = changeEntityToDTO(foodentity);
        return Optional.ofNullable(foodDTO);
    }

    public FoodEntity findEntityByName(String name) {
        List<FoodEntity> result = em.createQuery("select m from FoodEntity m where m.name =:name", FoodEntity.class).setParameter("name",name)
                .getResultList();
        if(result.stream().findAny().isEmpty())return null;
        else return result.get(0);
    }

    public FoodEntity findEntityById(Long id) {
        FoodEntity foodentity =  em.find(FoodEntity.class,id);
        return foodentity;
    }


    public FoodDTO findDTOByName(String name) {
        FoodEntity foodEntity = findEntityByName(name);
        if(!Optional.ofNullable(foodEntity).isPresent()) {
            return null;
        }
        FoodDTO foodDTO = changeEntityToDTO(foodEntity);
        return foodDTO;
    }

    public List<FoodDTO> findAll() {
        List<FoodEntity> AllEntities = em.createQuery("select f from FoodEntity f", FoodEntity.class).getResultList();
        List<FoodDTO> result = new ArrayList<>();
        for(FoodEntity foodEntity : AllEntities){
            result.add(changeEntityToDTO(foodEntity));
        }
        return result;
    }

    public Long findIdByName(String name){
        FoodEntity foodEntity = findEntityByName(name);
        if(Optional.ofNullable(foodEntity).isPresent()) {
            return foodEntity.getId();
        }
        else return null;
    }

}
