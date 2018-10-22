package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.persistence.FoodRepository;

import javax.annotation.Resource;
import java.util.List;

public abstract class Animal extends Food implements AnimalInterface {
    protected String name;

    protected List<Food> foods;

    @Resource
    protected FoodRepository foodRepository;

    Animal(){
        type = type();
    }

    @Override
    public boolean is(String type){
        return type.equals(type());
    }

    @Override
    public AnimalInterface nameAnimal(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String type(){
        String domainName = this.getClass().getName();
        return domainName.substring(domainName.lastIndexOf('.')+1);
    }

    @Override
    public String name(){
        return name;
    }

    @Override
    public int getIntake() {
        return 2000;
    }

    @Override
    public boolean isAnimal(){
        return true;
    }

    @Override
    public void eats(List<Food> foods){
        this.foods = foods;
    }

    @Override
    public List<Food> eats(){
        return foods;
    }
}
