package com.example.demo.domain.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    //음식 전체 리스트 확인
    @GetMapping("foods/list")
    @ResponseBody
    public List<FoodDTO> showFoodList(){
        return foodService.showList();
    }

    //음식 조회 요청
    @PostMapping("foods/find")
    @ResponseBody
    public FoodDTO findFood(FoodDTO foodDTO){
        return foodService.findFood(foodDTO.getName());
    }

    //음식 등록
    @GetMapping("foods/new")
    public String createNewFoodForm(){
        return "foods/createFoodForm";
    }

    @PostMapping("foods/new")
    public String createNewFood(FoodDTO foodDTO){
        foodService.joinNewFood(foodDTO);
        return "redirect:/";
    }

    //음식 삭제
    @PostMapping("foods/remove")
    public String removeFood(FoodDTO foodDTO){
        foodService.removeFood(foodDTO.getName());
        return "redirect:/";
    }

    //음식 수정
    @GetMapping("foods/change")
    public String createChangeFoodForm(){
        return "foods/changeFoodForm";
    }

    @PostMapping("foods/change")
    public String changeFood(FoodDTO foodDTO){
        foodService.changeFood(foodDTO);
        return "redirect:/";
    }


}