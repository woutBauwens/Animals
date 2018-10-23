package com.agfa.demo.persistence;

import com.agfa.demo.domain.Food;

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

    public FoodEntity(Food food){
        this.calories = food.getIntake();
        this.type = food.toString();
    }

    public FoodEntity getEntity(Food food){
        this.calories = food.getIntake();
        this.type = food.type();
        return this;
    }

    public boolean isOfType(String type){
        return this.type.equals(type);
    }

    public Long getId(){
        return id;
    }
}
