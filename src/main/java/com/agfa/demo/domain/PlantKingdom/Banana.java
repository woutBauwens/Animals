package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Food;
import org.springframework.stereotype.Component;

@Component
public class Banana extends Food implements Vegetable {

    public Banana(){
        type = "Banana";
        calories = 100;
    }

    @Override
    public int getIntake() {
        return calories;
    }

    @Override
    public void grow() {
        calories += 10;
    }

    @Override
    public Vegetable weedSeed() {
        return this;
    }

    @Override
    public String parent() {
        return "BananaTree";
    }

    @Override
    public boolean isPlant() {
        return false;
    }

    @Override
    public boolean is(String type) {
        return type.equals(type());
    }

    @Override
    public String printLine() {return "The " + type() + " is hanging on the " + parent();}
}
