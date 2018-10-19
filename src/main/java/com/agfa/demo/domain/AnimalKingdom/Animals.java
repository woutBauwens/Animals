package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.UI.PrintAnimals;
import com.agfa.demo.persistence.AnimalEntity;
import com.agfa.demo.persistence.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Animals {

    private List<AnimalInterface> animalInterfaces = new ArrayList<>();

    @Autowired
    private AnimalService animalService;

    public Animals makeAnimal(String name, String type){
        return makeAnimal(name, AnimalFactory.createAnimal(type));
    }

    public Animals makeAnimal(String name, AnimalInterface animalInterface){
        animalInterfaces.add(animalInterface.nameAnimal(name));
        return this;
    }

    public void persist(){
        List<AnimalEntity> animalEntitieList = animalInterfaces.stream().map(AnimalEntity::new).collect(Collectors.toList());
        animalEntitieList.stream().forEach(animalService::insert);
        PrintAnimals.show(animalInterfaces);
    }
}
