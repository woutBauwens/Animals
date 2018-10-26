package com.agfa.demo.domain;

import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.PlantKingdom.Banana;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.domain.PlantKingdom.Vegetable;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class KingdomManager {

    private static Map<String, Kingdom> kingdomMap;
    private static Map<String, Supplier<Kingdom>> supplierMap;
    private static List<Supplier<Kingdom>> allSuppplierTypes;
    private static KingdomManager kingdomManager = new KingdomManager();

    private KingdomManager(){
        kingdomMap = new TreeMap<>();
        supplierMap = new TreeMap<>();
        allSuppplierTypes = Arrays.asList(BananaTree::new, Human::new, Chimp::new, Gorilla::new, Lion::new, Banana::new);
        getAllTypes().forEach(t -> kingdomMap.put(t.type(), t));
        allSuppplierTypes.forEach(t -> supplierMap.put(t.get().type(), t));
    }

    public static List<Eatable> getAllTypesOfFood(){
        List<Eatable> foods = new ArrayList<>();
        getAllTypes().forEach(t -> {if(t instanceof Eatable){foods.add((Eatable) t);}});
        return foods;
    }

    public static void add(String type, Kingdom food){
        kingdomMap.put(type, food);
    }

    public static Optional<Eatable> asFood(String food){
        return Optional.ofNullable((Eatable) kingdomMap.get(food));
    }

    public static Optional<Animal> asAnimal(String food){return Optional.ofNullable((Animal)supplierMap.get(food).get());}

    public static Optional<Vegetable> asVegetable(String food){return Optional.ofNullable((Vegetable)supplierMap.get(food).get());}

    private static List<Kingdom> getAllTypes(){
        return allSuppplierTypes.stream().map(Supplier::get).collect(Collectors.toList());
    }
}
