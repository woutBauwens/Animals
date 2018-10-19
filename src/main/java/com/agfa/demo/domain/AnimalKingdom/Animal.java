package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal extends Food implements AnimalInterface {
    protected String name;
    protected Set<Food> digests;

    Animal(){
        digests = new HashSet<>();
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
    public String toString() {
        return name + " is a " + type();
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
}
