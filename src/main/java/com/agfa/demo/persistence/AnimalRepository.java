package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.AnimalKingdom.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalRepository {

    @Autowired
    private AnimalService animalService;

    public void save(AnimalEntity animalEntity){
        animalService.insert(animalEntity);
    }

    public void saveAll(Animals animals){
        animals.persist();
    }

    public AnimalInterface receiveAnimal(Long animalId){
        return animalService.retrieve(animalId);
    }
}