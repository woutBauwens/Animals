package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Eatable;
import com.agfa.demo.domain.Kingdom;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AnimalImpl implements Animal, Eatable {
    private String name;
    private Eats foods;

    AnimalImpl(){
        foods = new Eats();
    }

    @Override
    public boolean is(String type){
        return type.equals(type());
    }

    @Override
    public Animal giveName(String name) {
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
    public List<Eatable> eats(){
        return foods.eat("Banana").build();
    }

    @Override
    public String printString(){
        return name + " eats " + eats().stream().map(Eatable::type).collect(Collectors.joining("s, ", "", "s"))  + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalImpl animal = (AnimalImpl) o;
        return Objects.equals(name, animal.name) && animal.is(type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    Eats.EatChain appetiteFor(String type){
        return foods.eat(type);
    }

    List<Eatable> create(Eats.EatChain appetite){
        return appetite.build();
    }
}
