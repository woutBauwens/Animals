package com.agfa.demo.domain;

import com.agfa.demo.domain.AnimalKingdom.Chimp;
import com.agfa.demo.domain.AnimalKingdom.Gorilla;
import com.agfa.demo.domain.AnimalKingdom.Human;
import com.agfa.demo.domain.AnimalKingdom.Lion;
import com.agfa.demo.domain.PlantKingdom.Banana;

import java.util.*;

public class FoodMapSingleton {

    private static Map<String, Eatable> supplierMap;
    private static FoodMapSingleton instance = new FoodMapSingleton();

    private FoodMapSingleton(){
        supplierMap = new TreeMap<>();
        List<Eatable> allTypesOfFood = getAllTypesOfFood();
        allTypesOfFood.forEach(f -> supplierMap.put(f.type(), f));
    }

    public static void add(String type, Eatable food){
        supplierMap.put(type, food);
    }

    public static Optional<Eatable> get(String food){
        return Optional.ofNullable(supplierMap.get(food));
    }

    public static List<Eatable> getAllTypesOfFood(){
        return Arrays.asList(new Banana(true), new Human(), new Chimp(), new Gorilla(), new Lion());
    }
}
