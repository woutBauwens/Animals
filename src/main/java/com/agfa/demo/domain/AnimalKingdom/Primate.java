package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;

import java.util.List;

public abstract class Primate extends AnimalImpl {

    @Override
    public int getIntake() {
        return 2500;
    }

    @Override
    public List<Eatable> eats() {
        return create(appetiteFor("Banana"));
    }
}
