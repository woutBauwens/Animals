package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;

import java.util.List;

public interface AnimalInterface {

    AnimalInterface nameAnimal(String name);
    String type();
    boolean is(String type);
    String name();

    List<Food> eats();
    void eats(List<Food> foods);
}
