package com.example.demo.domain.food;

import com.example.demo.domain.exception.InputDuplicateNameException;
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


    public void removeFood(String name){
        foodRepository.remove(name);
    }

    public void updateFood(FoodDTO foodDTO){
        foodRepository.update(foodDTO);
    }

    public void updateFoodV2(Long id, FoodDTO foodDTO){
        foodRepository.updateV2(id,foodDTO);
    }

    public List<FoodDTO> showList(){
        return foodRepository.findAllDTO();
    }

    public Optional<FoodDTO> findFoodDTOById(long id){
        return foodRepository.findDTOById(id);
    }

    public void joinNewFood(FoodDTO foodDTO){
        //음식 이름 중복 검증
        Optional.ofNullable(foodRepository.findDTOByName(foodDTO.getName())).
            ifPresent(f->{
                throw new InputDuplicateNameException();
            });
        foodRepository.save(foodDTO);
    }

    public Long findFoodIdByName(String name){
        return foodRepository.findIdByName(name);
    }

}
