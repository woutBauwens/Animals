package com.agfa.demo.domain.AnimalKingdom;


import com.agfa.demo.domain.Eatable;

import java.util.List;

public class Lion extends AnimalImpl {

    @Override
    public List<Eatable> eats() {
        return create(appetiteFor("Human").and("Gorilla").and("Chimp").and("Lion"));
    }

    @Override
    public int getIntake() {
        return 5000;
    }
}
