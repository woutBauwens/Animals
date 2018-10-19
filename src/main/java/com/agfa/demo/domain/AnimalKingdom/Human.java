package com.agfa.demo.domain.AnimalKingdom;

import org.springframework.stereotype.Component;

@Component
public class Human extends Primate {

    private Long id;

    @Override
    public String eats(){
        return "Everything";
    }
}
