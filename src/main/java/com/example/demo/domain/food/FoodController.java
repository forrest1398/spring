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


    @GetMapping("")
    @ResponseBody
    public List<FoodDTO> showFoodList(){
        return foodService.showList();
    }

    @PostMapping("")
    public String findFoodIdByName(@RequestParam String name){
        if(foodService.findFoodIdByName(name) != null) {
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

    @GetMapping("/newfood")
    public String createNewFoodForm(){
        return "foods/createFoodForm";
    }

    @PostMapping("/newfood")
    public String createNewFood(FoodDTO foodDTO){
        foodService.joinNewFood(foodDTO);

        return "redirect:/";
    }

    //음식 삭제
    @DeleteMapping("")
    public String removeFood(@RequestParam String name){
        foodService.removeFood(name);
        return "redirect:/";
    }

    //음식 삭제 version2
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
    public String changeFoodByName(FoodDTO foodDTO){
        foodService.updateFood(foodDTO);
        return "redirect:/";
    }

    //음식 수정 version2
    @PutMapping("/{id}")
    public String changeFoodByIdVersin2(FoodDTO foodDTO,@PathVariable("id")String id){
        foodService.updateFoodV2(Long.valueOf(id),foodDTO);
        return "redirect:/";
    }

}