package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.persistence.FoodRepository;

import javax.annotation.Resource;

public abstract class Primate extends Animal {

    @Resource
    protected FoodRepository foodRepository;

    @Override
    public int getIntake() {
        return 2500;
    }
}
