package com.agfa.demo.domain;

import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.PlantKingdom.Banana;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.domain.PlantKingdom.Vegetable;

public class KingdomFactory {

    public static Kingdom createLife(String type){
        return createAnimal(type);
    }

    public static AnimalInterface createAnimal(String type){
        switch(type) {
            case "Human":
                return new Human();
            case "Chimp":
                return new Chimp();
            case "Gorilla":
                return new Gorilla();
            case "Lion":
                return new Lion();
            default:
                return new Human();
        }
    }

    public static Vegetable createVegetable(String type){
        switch(type) {
            case "Banana":
                return new Banana();
            case "BananaTree":
                return new BananaTree();
            default:
                return new Banana();
        }
    }
}
