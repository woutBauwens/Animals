package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;

import java.util.List;

public class Human extends Primate {

    @Override
    public List<Eatable> eats() {
        return create(appetiteFor("Banana").and("Chimp"));
    }
}
