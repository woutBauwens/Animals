package com.agfa.demo.domain.AnimalKingdom;

public class Lion extends AnimalImpl {

    @Override
    public Eats.EatChain eats() {
        return super.eats().eat("Human").eat("Chimp").eat("Lion").eat("Gorilla");
    }

    @Override
    public int getIntake() {
        return 5000;
    }
}
