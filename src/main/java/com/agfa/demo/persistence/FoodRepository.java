package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.AnimalKingdom.Animals;
import com.agfa.demo.domain.PlantKingdom.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodRepository {

    @Autowired
    private FoodService foodService;

    public void save(FoodEntity foodEntity){
        foodService.insert(foodEntity);
    }

    public void saveFoodFromPlant(Plant plant){
        plant.persistFoodFromPlant();
    }

   // public AnimalInterface receiveAnimal(Long animalId){
   //     return animalService.retrieve(animalId);
   // }
}