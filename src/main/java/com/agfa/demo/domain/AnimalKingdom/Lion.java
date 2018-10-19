package com.agfa.demo.domain.AnimalKingdom;


import com.agfa.demo.domain.Food;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Lion extends Animal {

    @Override
    public String eats() {
        digests.addAll(Arrays.asList(new Food[] {new Human(), new Gorilla(), new Chimp(), new Lion()}));
        return digests.stream().map(food -> food.getType()).collect(Collectors.toList()).toString();
    }

    @Override
    public int getIntake() {
        return 5000;
    }
}
