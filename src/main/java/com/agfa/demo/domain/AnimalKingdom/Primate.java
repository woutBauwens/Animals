package com.agfa.demo.domain.AnimalKingdom;

public abstract class Primate extends AnimalImpl {

    @Override
    public int getIntake() {
        return 2500;
    }

    @Override
    public Eats.EatChain eats() {
        return super.eats().eat("Banana");
    }
}
