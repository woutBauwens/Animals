package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Food;
import org.springframework.stereotype.Component;

@Component
public class Banana extends Food {

    public Banana(){
        type = "Banana";
        calories = 150;
    }

    @Override
    public int getIntake() {
        return calories;
    }
}
