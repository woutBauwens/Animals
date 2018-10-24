package com.agfa.demo.persistence;

import com.agfa.demo.domain.Eatable;

import javax.persistence.*;

@Entity
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private int calories;

   @Column(name = "FOOD_TYPE")
   private String type;

    protected FoodEntity(){}

    FoodEntity(Eatable eatable){
        this.calories = eatable.getIntake();
        this.type = eatable.type();
    }
}
