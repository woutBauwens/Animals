package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import java.util.List;

public abstract class Primate extends Animal {

    @Override
    public int getIntake() {
        return 2500;
    }

    @Override
    public List<Food> eats() {
        return create(appetiteFor("Banana"));
    }
}
