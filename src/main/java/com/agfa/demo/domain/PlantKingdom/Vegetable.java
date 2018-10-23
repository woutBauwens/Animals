package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Kingdom;

public interface Vegetable extends Kingdom {

    void grow();

    Vegetable weedSeed();

    String parent();

    boolean isPlant();

}
