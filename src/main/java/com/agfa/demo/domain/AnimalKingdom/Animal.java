package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.Kingdom;

import java.util.List;

public interface Animal extends Kingdom {

    boolean is(String type);
    String name();
    Animal giveName(String name);

    List<Eatable> eats();
}
