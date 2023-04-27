package com.example.demo.domain.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    //음식 리스트
    @GetMapping("")
    @ResponseBody
    public List<FoodDTO> showFoodList(){
        return foodService.showList();
    }

    //음식 조회
    //FIXME 이걸 하나로 합칠 수는 없는지?
    @PostMapping("")
    public String findFoodIdByName(@RequestParam String name){
        if(Optional.ofNullable(foodService.findFoodIdByName(name)).isPresent()) {
            long id = foodService.findFoodIdByName(name);
            return "redirect:/"+"foods/"+Long.toString(id);
        }
        else
            return "redirect:/";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<FoodDTO> findFood(@PathVariable("id") String id){
        return foodService.findFoodDTOById(Long.valueOf(id));
    }

    //음식 생성
    @GetMapping("/newfood")
    public String createNewFoodForm(){
        return "foods/createFoodForm";
    }
    //FIXME 요놈은 도대체 왜 @REQUESTBODY 가 없는데도 잘 동작 잘하냐..
    @PostMapping("/newfood")
    public String createNewFood(FoodDTO foodDTO){
        foodService.joinNewFood(foodDTO);
        return "redirect:/";
    }

    //음식 삭제 - by name
    @DeleteMapping("")
    public String removeFood(@RequestParam String name){
        foodService.removeFood(name);
        return "redirect:/";
    }

    //음식 삭제 version2 - by id
    //fixme 왜 갑자기 안되냐
    @DeleteMapping("/{id}")
    public String removeFoodById(@PathVariable("id") String id){
        foodService.findFoodDTOById(Long.valueOf(id)).
                //삭제 대상이 존재하는지 확인
                ifPresent(foodDTO->{
                    foodService.removeFood(foodDTO.getName());
                });
        return "redirect:/";
    }


    //음식 수정
    @GetMapping("/change")
    public String createChangeFoodForm(){
        return "foods/changeFoodForm";
    }
    @PostMapping("/change")
    public String changeFood(FoodDTO foodDTO){
        foodService.changeFood(foodDTO);
        return "redirect:/";
    }

//    음식수정 version2
//    @PutMapping("/{id}")
//    public String changeFoodVersin2(FoodDTO form,@PathVariable("id")String id){
//        foodService.changeFoodv2(Long.valueOf(id),form);
//        return "redirect:/";
//    }


}