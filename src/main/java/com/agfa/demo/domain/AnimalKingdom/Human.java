package com.agfa.demo.domain.AnimalKingdom;

public class Human extends Primate {

    @Override
    public Eats.EatChain eats() {
        return super.eats().eat("Chimp");
    }
}
