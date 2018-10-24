package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Kingdom;

public class Banana extends Fruit {

    private String parent;

    public Banana(){
        parent = "BananaTree";
    }

    public Banana(String parent){
        this.parent = parent;
    }

    @Override
    public int getIntake() {
        return 100;
    }

    @Override
    public void grow(int amount) {}

    @Override
    public String parent() {
        return parent;
    }

    @Override
    public Kingdom giveName(String name) {
        parent = name;
        return this;
    }

    @Override
    public String printString() {return "The " + type() + " is hanging on " + parent;}
}
