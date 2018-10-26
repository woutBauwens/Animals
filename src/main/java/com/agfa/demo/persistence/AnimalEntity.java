package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.Animal;
import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.domain.KingdomFactory;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue(value = "Animal")
public class AnimalEntity extends LivingEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Basic(fetch = FetchType.LAZY)
    private List<FoodEntity> eats;

    protected AnimalEntity() {
    }

    AnimalEntity(Animal animal) {
        this.name = animal.name();
        this.type = animal.type();
        this.eats = animal.getFood().stream().map(FoodEntity::new).collect(Collectors.toList());
        parent = type;
    }

    Kingdom mapToAnimal() {
        return KingdomFactory.createAnimal(type).giveName(name);
    }
}
