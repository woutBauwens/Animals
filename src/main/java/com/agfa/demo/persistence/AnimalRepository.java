package com.agfa.demo.persistence;

import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.domain.KingdomFactory;
import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.Food;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class AnimalRepository {

    @Resource
    private AnimalService animalService;

    public AnimalRepository makeAnimal(String name, String type){
        return makeAnimal(name, KingdomFactory.createAnimal(type));
    }

    public AnimalRepository makeAnimal(String name,
                                       AnimalInterface animalInterface){
        animalService.insert(animalInterface.nameAnimal(name));
        return this;
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
                .map(AnimalEntity::adapt)
                .filter(distrinctByName(AnimalInterface::unique))
                .collect(Collectors.toList());
    }

    private Predicate<? super AnimalInterface> distrinctByName(Function<? super AnimalInterface, ?> name) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(name.apply(t));
    }

    public void persist(List<AnimalInterface> animalList){
        animalList.stream().map(AnimalEntity::new)
                .forEach(animalService::insert);
    }
}