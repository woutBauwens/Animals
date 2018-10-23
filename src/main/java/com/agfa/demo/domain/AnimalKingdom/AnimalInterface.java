package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.domain.Kingdom;

import java.util.List;
import java.util.Map;

public interface AnimalInterface extends Kingdom {

    AnimalInterface nameAnimal(String name);
    boolean is(String type);
    String name();

    List<Food> eats();
    Map<String, String> unique();
}
