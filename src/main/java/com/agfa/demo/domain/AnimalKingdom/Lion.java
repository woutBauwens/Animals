package com.agfa.demo.domain.AnimalKingdom;


import com.agfa.demo.domain.Food;

import java.util.ArrayList;
import java.util.List;

public class Lion extends Animal {

    @Override
    public List<Food> eats() {
        return new ArrayList<>();
      //  return foodRepository.getAllTypesOfFood();// addAll(  )//Arrays.asList(new Food[] {new Human(), new Gorilla(), new Chimp(), new Lion()}));
      //  return digests;
    }

    @Override
    public int getIntake() {
        return 5000;
    }
}
