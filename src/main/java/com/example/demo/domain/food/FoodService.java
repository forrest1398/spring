package com.example.demo.domain.food;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }


    public List<FoodDTO> showList(){
        return foodRepository.findAll();
    }


    public Optional<FoodDTO> findFoodDTOById(long id){
        return foodRepository.findDTOById(id);
    }


    public void joinNewFood(FoodDTO foodDTO){
        //음식 이름 중복 검증
        Optional.ofNullable(foodRepository.findDTOByName(foodDTO.getName())).
            ifPresent(f->{
                throw new IllegalStateException("Error : already have same name food");
            });
        foodRepository.save(foodDTO);
    }


    public void removeFood(String name){
        foodRepository.remove(name);
    }


    public void changeFood(FoodDTO foodDTO){
        foodRepository.update(foodDTO);
    }

    public void changeFoodv2(Long id,FoodDTO newone){
        foodRepository.updatev2(id,newone);
    }

    public Long findFoodIdByName(String name){
        if(Optional.ofNullable(foodRepository.findIdByName(name)).isPresent()) {
            long id = foodRepository.findIdByName(name);
            return id;
        }
        else
            return null;
    }

}
