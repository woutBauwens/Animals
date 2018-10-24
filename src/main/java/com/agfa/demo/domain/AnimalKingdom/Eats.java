package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.PlantKingdom.Banana;

import java.util.ArrayList;
import java.util.List;

public class Eats {
    private List<Eatable> eatableList;
    private EatChain chain;

    public Eats(){
        eatableList = new ArrayList<>();
        chain = new EatChain();
    }

    public EatChain eat(String food){
        createFactory(food);
        return chain;
    }

    public class EatChain {
        public EatChain and(String food){
            createFactory(food);
            return this;
        }

        public List<Eatable> build() {
            List<Eatable> eatables = eatableList;
            eatableList = new ArrayList<>();
            return eatables;
        }
    }

    private void createFactory(String food){
        switch(food) {
            case "Human":
                eatableList.add(new Human());
                break;
            case "Chimp":
                eatableList.add(new Chimp());
                break;
            case "Gorilla":
                eatableList.add(new Gorilla());
                break;
            case "Lion":
                eatableList.add(new Lion());
                break;
            case "Banana":
                eatableList.add(new Banana());
                break;
            default:
                eatableList.add(new Human());
                break;
        }
    }
}
