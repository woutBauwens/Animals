package com.agfa.demo.persistence;

import com.agfa.demo.domain.Food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FoodEntity {

    @Id
    @GeneratedValue
    private Long id;

    protected int calories;
    protected boolean goneBad;
    protected String type;

    protected FoodEntity(){}

    public FoodEntity(Food food){
        this.calories = food.getIntake();
        this.type = food.toString();
    }
}
