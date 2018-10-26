package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.AnimalKingdom.Eats;
import com.agfa.demo.domain.Eatable;

public abstract class Fruit implements Vegetable, Eatable {

    private Eats foods;

    @Override
    public boolean isAnimal() {
        return false;
    }

    @Override
    public Vegetable weedSeed(String seed) {
        return this;
    }

    @Override
    public String type() {
        String domainName = this.getClass().getName();
        return domainName.substring(domainName.lastIndexOf('.')+1);
    }

    @Override
    public boolean is(String type) {
        return type.equals(type());
    }

    @Override
    public String name(){
        return type();
    }

    @Override
    public void addAsFood() {
        foods = new Eats();
        try {
            foods.addAsFood(type(), getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
