package com.agfa.demo.UI;

import com.agfa.demo.domain.Kingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAnimals {

    private static List<Kingdom> kingdom = new ArrayList<>();

    public static void show(List<Kingdom> animals){
        kingdom = animals;
        showTypes();
    }

    private static void showTypes(){
        System.out.println(kingdom.stream().map(Kingdom::type).distinct()
                .map(PrintAnimals::getLine).collect(Collectors.joining()));
    }

    private static String getLine(String type) {
        return  kingdom.stream().filter(animal ->
                animal.is(type))
                .map(Kingdom::printString)
                .collect(Collectors.joining("\n", "\n" + type + "s:\n", "\n"));
    }


}
