package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Kingdom;

import java.util.List;

public abstract class Plant implements Vegetable {

    String name;

    @Override
    public String type(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String parent(){
        return type();
    }

    @Override
    public String printString() {return name();}

    @Override
    public boolean isAnimal() {
        return false;
    }

    public Vegetable giveName(String name) {
        this.name = name;
        return this;
    }

    public abstract List<Kingdom> getTree();
}
