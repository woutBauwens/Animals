package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalFactory;
import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.AnimalKingdom.Human;
import com.agfa.demo.domain.Food;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;

    private String name;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodEntity> eats;

    protected AnimalEntity(){}

    public AnimalEntity(AnimalInterface animalInterface){
        this.name = animalInterface.name();
        this.type = animalInterface.type();
    }

    public AnimalEntity buildFoodKingdom(List<FoodEntity> foods){
        eats = foods;
        return this;
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