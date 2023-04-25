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

    //음식 리스트 기능
    public List<FoodDTO> showList(){
        return foodRepository.findAll();
    }

    //음식 조회 기능
    public FoodDTO findFood(String name){
        return foodRepository.findByName(name);
    }

    //음식 등록 기능
    public void joinNewFood(FoodDTO foodDTO){

        //음식 이름 중복 검증
        Optional.ofNullable(foodRepository.findByName(foodDTO.getName())).
            ifPresent(f->{
                //중복시 예외처리
                throw new IllegalStateException("Error : already have same name food");
            });

        foodRepository.save(foodDTO);
    }

}
