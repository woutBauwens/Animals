package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Kingdom;

public interface Vegetable extends Kingdom {

    void grow(int amount);

    Vegetable weedSeed(String name);

    String parent();

    String name();
}
