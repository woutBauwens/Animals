package com.agfa.demo;

import com.agfa.demo.UI.PrintAnimals;
import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.persistence.AnimalRepository;
import com.agfa.demo.persistence.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private AnimalRepository animals;
    private BananaTree bananaTree;
    private FoodRepository foodRepository;

    public DemoApplication(AnimalRepository animals, BananaTree bananaTree, FoodRepository foodRepository) {
        this.animals = animals;
        this.bananaTree = bananaTree;
        this.foodRepository = foodRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        foodRepository.initFoods();
        animals.populate();
        bananaTree.grow();

        List<Kingdom> kingdoms = animals.getAllAnimals();
        kingdoms.addAll(bananaTree.getTree());
        PrintAnimals.show(kingdoms);
    }
}
