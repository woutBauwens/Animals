package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public abstract class Animal extends Food implements AnimalInterface {
    private String name;
    private Eats foods;

    Animal(){
        type = type();
        foods = new Eats();
    }

    @Override
    public boolean is(String type){
        return type.equals(type());
    }

    @Override
    public AnimalInterface nameAnimal(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String type(){
        String domainName = this.getClass().getName();
        return domainName.substring(domainName.lastIndexOf('.')+1);
    }

    @Override
    public String name(){
        return name;
    }

    @Override
    public int getIntake() {
        return 2000;
    }

    @Override
    public boolean isAnimal(){
        return true;
    }

    @Override
    public List<Food> eats(){
        return foods.eat("Banana").build();
    }

    @Override
    public String printLine(){
        return name + " eats " + eats().stream().map(Food::toString).collect(Collectors.joining("s, ", "", "s"))  + "";
    }

    @Override
    public Map<String, String> unique() {
        TreeMap<String, String> uniqueKV = new TreeMap<>();
        uniqueKV.put(name, type);
        return uniqueKV;
    }

    @Override
    public boolean equals(Object object){
        Animal a = (Animal) object;
        return a.name.equals(name) && a.is(type);
    }

    protected Eats.EatChain appetiteFor(String type){
        return foods.eat(type);
    }

    protected List<Food> create(Eats.EatChain appetite){
        return appetite.build();
    }
}
