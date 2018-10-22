package com.agfa.demo.domain.PlantKingdom;

public abstract class Plant implements Vegetable {

    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isPlant(){
        return true;
    }

    @Override
    public String parent(){
        return getType();
    }
}
