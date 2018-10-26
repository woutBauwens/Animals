package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.KingdomManager;
import com.agfa.demo.domain.Kingdom;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalRepository {

    @Resource
    private AnimalService animalService;

    private void makeAnimal(String name, String type){
        makeAnimal(name, KingdomManager.asAnimal(type).get());
    }

    public void makeAnimal(String name,
                                       Animal animal){
        animalService.insert(animal.giveName(name));
    }

    public void populate() {
        makeAnimal("Wout", "Human");
        makeAnimal("Arne", "Chimp");
        makeAnimal("Tim", "Human");
        makeAnimal("Tom", new Human());
        makeAnimal("Sofie", new Chimp());
        makeAnimal("Freddy", new Lion());
        makeAnimal("George", new Gorilla());
        makeAnimal("Tom", new Lion());
    }

    public List<Kingdom> getAllAnimals(){
        return animalService.getAllAnimals().stream()
                .map(AnimalEntity::mapToAnimal)
                .distinct()
                .collect(Collectors.toList());
    }

    public void persist(List<Animal> animalList){
        animalList.stream().map(AnimalEntity::new)
                .forEach(animalService::insert);
    }
}