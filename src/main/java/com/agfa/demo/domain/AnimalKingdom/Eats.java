package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.domain.PlantKingdom.Banana;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Eats {
    private List<Food> foodList;
    private EatChain chain;

    public Eats(){
        foodList = new ArrayList<>();
        chain = new EatChain();
    }

    public EatChain eat(String food){
        createFactory(food);
        return chain;
    }

    public List<Food> getFood(){
        return foodList;
    }

    public void setFood(List<Food> foods) {
        foodList = foods;
    }

    protected class EatChain {
        public EatChain and(String food){
            createFactory(food);
            return this;
        }

        public List<Food> build() {
            List<Food> foods = foodList;
            foodList = new ArrayList<>();
            return foods;
        }
    }

    private void createFactory(String food){
        switch(food) {
            case "Human":
                foodList.add(new Human());
                break;
            case "Chimp":
                foodList.add(new Chimp());
                break;
            case "Gorilla":
                foodList.add(new Gorilla());
                break;
            case "Lion":
                foodList.add(new Lion());
                break;
            case "Banana":
                foodList.add(new Banana());
                break;
            default:
                foodList.add(new Human());
                break;
        }
    }
}
