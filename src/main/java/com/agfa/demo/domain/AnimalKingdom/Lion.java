package com.agfa.demo.domain.AnimalKingdom;


import com.agfa.demo.domain.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lion extends Animal {

    @Override
    public List<Food> eats() {
        return create(appetiteFor("Human").and("Gorilla").and("Chimp").and("Lion"));
    }

    @Override
    public int getIntake() {
        return 5000;
    }
}
