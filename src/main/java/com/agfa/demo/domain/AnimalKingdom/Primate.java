package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.PlantKingdom.Banana;

public abstract class Primate extends Animal {

    @Override
    public int getIntake() {
        return 2500;
    }

    @Override
    public String eats(){
        digests.add(new Banana());
        return digests.toString();
    }
}
