package com.agfa.demo.persistence;

import com.agfa.demo.domain.PlantKingdom.Vegetable;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Vegetable")
@NamedQuery(
        name = "getAllPlantEntities",
        query = "SELECT plant FROM PlantEntity plant"
)
public class PlantEntity extends LivingEntity {
    protected PlantEntity(){}

    PlantEntity(Vegetable vegetable){
        type = vegetable.type();
        parent = vegetable.parent();
        name = vegetable.name();
    }

    public String getType() {
        return type;
    }

    public String getName(){
        return name.equals(type)?parent:name;
    }
}
