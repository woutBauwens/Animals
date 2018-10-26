package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.domain.KingdomManager;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Supplier;

@Component
public class Eats {
    private List<Eatable> eatableList;
    private EatChain chain;
    private Map<String, Eatable> supplierMap;

    public Eats(){
        eatableList = new ArrayList<>();
        chain = new EatChain();
        supplierMap = new TreeMap<>();
    }

    public EatChain start(){
        return chain;
    }

    public class EatChain {
        public EatChain eat(String food){
            createFactory(food);
            return this;
        }

        public List<Eatable> build() {
            List<Eatable> eatables = eatableList;
            eatableList = new ArrayList<>();
            return eatables;
        }
    }

    public void addAsFood(String typeName, Supplier<Kingdom> newObject){
        KingdomManager.add(typeName, newObject);
    }

    public void addAsFood(String typeName, Eatable eatable){
        KingdomManager.add(typeName, eatable);
    }

    private void createFactory(String food){
        Optional<Eatable> eatable = KingdomManager.asFood(food);
        if(eatable.isPresent()){
        Eatable foodSupplier = eatable.get();
        eatableList.add(foodSupplier);}
 /*       switch(food) {
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
        }*/
    }
}
