package com.agfa.demo.persistence;

import com.agfa.demo.UI.PrintAnimals;
import com.agfa.demo.domain.AnimalKingdom.AnimalFactory;
import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.Food;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AnimalRepository {

    @Resource
    private AnimalService animalService;

    private List<Food> digests;

    public AnimalRepository makeAnimal(String name, String type){
        return makeAnimal(name, AnimalFactory.createAnimal(type));
    }

    public AnimalRepository makeAnimal(String name, AnimalInterface animalInterface){
        animalInterface.eats(digests);
        animalService.insert(animalInterface.nameAnimal(name));
        return this;
    }

    public void persist(List<AnimalInterface> animalList){
        animalList.stream().map(AnimalEntity::new)
            .forEach(animalService::insert);
        PrintAnimals.show(animalList);
    }

    public AnimalInterface receiveAnimal(Long animalId){
        return animalService.retrieve(animalId);
    }

    public void buildFoodCYcle(List<Food> allTypesOfFood) {
        digests = allTypesOfFood;
    }
}