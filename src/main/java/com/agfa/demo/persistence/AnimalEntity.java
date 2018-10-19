package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalFactory;
import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.AnimalKingdom.Human;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnimalEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private String eats;

    protected AnimalEntity(){}

    public AnimalEntity(AnimalInterface animalInterface){
        this.name = animalInterface.name();
        this.type = animalInterface.type();
        this.eats = animalInterface.eats();
    }

    public static AnimalInterface adapt(AnimalEntity animalEntity) {
        try {
            return AnimalFactory.createAnimal(animalEntity.type).nameAnimal(animalEntity.name);
        } catch (NullPointerException exception) {
            System.out.println("Animal not found. Creating new animal");
            return new Human();
        }
    }
}
