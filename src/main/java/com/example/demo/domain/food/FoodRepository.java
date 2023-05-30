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


    public void save(FoodDTO foodDTO) {
        FoodEntity foodEntity = foodDTO.changeDTOToEntity();
        em.persist(foodEntity);
    }

    public void remove(String name){
        FoodEntity result = em.find(FoodEntity.class,findIdByName(name));
        if(result != null)
            em.remove(result);
    }

    public void update(FoodDTO foodDTO){
        FoodEntity target = em.find(FoodEntity.class,findIdByName(foodDTO.getName()));
        if(target != null){
            target.updateFoodEntity(
                    foodDTO.getPrice(),
                    foodDTO.getName(),
                    foodDTO.getComments(),
                    foodDTO.getStoreLocation());
            em.merge(target);
        }
    }

    public void updateV2(Long id, FoodDTO foodDTO){
        FoodEntity target = findEntityById(id);
        target.updateFoodEntity(
                foodDTO.getPrice(),
                foodDTO.getName(),
                foodDTO.getComments(),
                foodDTO.getStoreLocation());
        em.merge(target);
        em.merge(target);
    }

    public Long findIdByName(String name){
        FoodEntity foodEntity = findEntityByName(name);
        if(foodEntity != null) {
            return foodEntity.getId();
        }
        else return null;
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

    public List<FoodDTO> findAllDTO() {
        List<FoodEntity> AllEntities = em.createQuery("select f from FoodEntity f", FoodEntity.class).getResultList();
        List<FoodDTO> result = new ArrayList<>();
        for(FoodEntity foodEntity : AllEntities){
            result.add(foodEntity.changeEntityToDTO());
        }
        return result;
    }

    public FoodDTO findDTOByName(String name) {
        FoodEntity foodEntity = findEntityByName(name);
        if(!Optional.ofNullable(foodEntity).isPresent()) {
            return null;
        }
        FoodDTO foodDTO = foodEntity.changeEntityToDTO();
        return foodDTO;
    }

    public Optional<FoodDTO> findDTOById(Long id) {
        FoodEntity foodentity =  em.find(FoodEntity.class,id);
        FoodDTO foodDTO = foodentity.changeEntityToDTO();
        return Optional.ofNullable(foodDTO);
    }

}
