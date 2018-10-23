package com.agfa.demo.domain.PlantKingdom;

public abstract class Plant implements Vegetable {

    @Override
    public String type(){
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isPlant(){
        return true;
    }

    @Override
    public String parent(){
        return type();
    }

    @Override
    public String printLine() {return type();}
}
