package com.agfa.demo.UI;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAnimals {

    private static List<AnimalInterface> animalInterfaces = new ArrayList<>();

    public static void show(List<AnimalInterface> animals){
        animalInterfaces = animals;
        showOverview();
        showTypes();
    }

    private static void showOverview(){
        System.out.print(animalInterfaces.stream().map(AnimalInterface::toString).collect(Collectors.joining("\n", "\n", "\n")));
    }

    private static void showTypes(){
        List<String> types = animalInterfaces.stream().map(AnimalInterface::type).distinct().collect(Collectors.toList());
        types.parallelStream().forEach(type -> System.out.print("\n" + type + "s:" + animalInterfaces.stream().filter(animal -> animal.is(type)).map(AnimalInterface::name).collect(Collectors.joining("\n", "\n", "\n"))));
    }
}
