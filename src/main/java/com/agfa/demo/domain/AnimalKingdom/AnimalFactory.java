package com.agfa.demo.domain.AnimalKingdom;

public class AnimalFactory {

    public static AnimalInterface createAnimal(String type){
        switch (type) {
            case "Human":
                return new Human();
            case "Chimp":
                return new Chimp();

            default: return new Human();
        }
    }
}
