package com.agfa.demo.domain;

public abstract class Food {

    protected int calories;
    protected boolean goneBad;
    protected int age;
    protected String type;

    public Food(){
        goneBad = false;
        age = 0;
    }

    public abstract int getIntake();

    @Override
    public String toString(){
        return type;
    }

    public String getType(){
        return type;
    }
}
