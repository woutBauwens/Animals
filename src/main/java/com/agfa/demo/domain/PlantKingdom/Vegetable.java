package com.agfa.demo.domain.PlantKingdom;

public interface Vegetable {

    void grow();

    Vegetable weedSeed();

    String getType();

    String parent();

    boolean isPlant();
}
