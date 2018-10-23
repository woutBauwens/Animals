package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Human extends Primate {

    private Long id;

    @Override
    public List<Food> eats() {
        return create(appetiteFor("Banana").and("Chimp"));
    }
}
