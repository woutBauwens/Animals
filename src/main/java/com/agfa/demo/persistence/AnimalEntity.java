package com.agfa.demo.persistence;

import com.agfa.demo.domain.KingdomFactory;
import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import com.agfa.demo.domain.AnimalKingdom.Human;

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

    AnimalEntity(AnimalInterface animalInterface){
        this.name = animalInterface.name();
        this.type = animalInterface.type();
        this.eats = animalInterface.eats().stream().map(FoodEntity::new).collect(Collectors.toList());
    }

    static AnimalInterface adapt(AnimalEntity animalEntity) {
        try {
            return KingdomFactory.createAnimal(animalEntity.type).nameAnimal(animalEntity.name);
        } catch (NullPointerException exception) {
            System.out.println("Animal not found. Creating new animal");
            return new Human();
        }
    }
}
