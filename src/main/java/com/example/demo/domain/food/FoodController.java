package com.example.demo.domain.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }


    //음식 리스트 확인
    @GetMapping("foods/list")
    @ResponseBody
    public List<FoodEntity> foodList(){
        return foodService.showList();
    }

    //음식 등록
    @GetMapping("foods/new")
    public String createForm(){
        return "foods/createFoodForm";
    }
    @PostMapping("foods/new")
    public String create(FoodForm form){

        FoodEntity foodEntity = new FoodEntity();

        foodEntity.setId(form.getId());
        foodEntity.setPrice(form.getPrice());
        foodEntity.setName(form.getName());
        foodEntity.setComments(form.getComments());
        foodEntity.setStoreLocation(form.getStoreLocation());

        foodService.join(foodEntity);

        return "redirect:/";
    }

    //음식 조회 요청
    @PostMapping("foods/find")
    @ResponseBody
    public Optional<FoodEntity> findFood(FoodForm form){
        return foodService.findFood(form.getName());
    }

}