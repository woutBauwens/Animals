package com.agfa.demo.domain;

public abstract class Food implements Kingdom{
    protected int calories;
    protected String type;

    public abstract int getIntake();

    @Override
    public String toString(){
        return type;
    }

    public String type(){
        return type;
    }

    public boolean isAnimal(){
        return false;
    }
}
