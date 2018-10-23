package com.agfa.demo.UI;

import com.agfa.demo.domain.Kingdom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAnimals {

    private static List<Kingdom> kingdom = new ArrayList<>();

    public static void show(List<Kingdom> animals){
        kingdom = animals;
   //     showOverview();
        showTypes();
    }

    private static void showOverview(){
        System.out.print(kingdom.stream().map(Kingdom::toString).collect(Collectors.joining("\n", "\n", "\n")));
    }

    private static void showTypes(){
        List<String> types = kingdom.stream().map(Kingdom::type).distinct().collect(Collectors.toList());
        types.parallelStream().forEach(type ->
                System.out.print("\n" + type + "s:" + kingdom.stream().filter(
                        animal -> animal.is(type)).map(Kingdom::printLine)
                        .collect(Collectors.joining("\n", "\n", "\n")))
        );
    }
}
