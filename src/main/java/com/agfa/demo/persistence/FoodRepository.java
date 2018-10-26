package com.agfa.demo.persistence;

import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.KingdomManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FoodRepository {

    @Resource
    private FoodService foodService;

    public void initFoods(){
        KingdomManager.getAllTypesOfFood().stream().map(FoodEntity::new).forEach(foodService::insert);
    }

    public void save(FoodEntity foodEntity){
        foodService.insert(foodEntity);
    }

    public FoodEntity getFoodEntity(Eatable eatable){
        return foodService.getFood(eatable.type());
    }
}