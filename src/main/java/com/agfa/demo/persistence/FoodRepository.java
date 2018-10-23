package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.Chimp;
import com.agfa.demo.domain.AnimalKingdom.Gorilla;
import com.agfa.demo.domain.AnimalKingdom.Human;
import com.agfa.demo.domain.AnimalKingdom.Lion;
import com.agfa.demo.domain.Food;
import com.agfa.demo.domain.PlantKingdom.Banana;
import com.agfa.demo.domain.PlantKingdom.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodRepository {

    @Resource
    private FoodService foodService;

    public void initFoods(){
        getAllTypesOfFood().stream().map(FoodEntity::new).forEach(foodService::insert);
    }

    public void save(FoodEntity foodEntity){
        foodService.insert(foodEntity);
    }

    public List<Food> getAllTypesOfFood(){
       return Arrays.asList(new Food[]{new Banana(), new Human(), new Chimp(), new Gorilla(), new Lion()});
    }

    public FoodEntity getFoodEntity(Food food){
        return foodService.getFood(food.type());
    }
}