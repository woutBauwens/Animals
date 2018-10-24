package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.Chimp;
import com.agfa.demo.domain.AnimalKingdom.Gorilla;
import com.agfa.demo.domain.AnimalKingdom.Human;
import com.agfa.demo.domain.AnimalKingdom.Lion;
import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.PlantKingdom.Banana;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    public List<Eatable> getAllTypesOfFood(){
       return Arrays.asList(new Banana(), new Human(), new Chimp(), new Gorilla(), new Lion());
    }

    public FoodEntity getFoodEntity(Eatable eatable){
        return foodService.getFood(eatable.type());
    }
}