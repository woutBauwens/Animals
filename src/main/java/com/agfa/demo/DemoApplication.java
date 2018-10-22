package com.agfa.demo;

import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.persistence.AnimalRepository;
import com.agfa.demo.persistence.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

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

        animals.buildFoodCYcle(foodRepository.getAllTypesOfFood());
        animals.makeAnimal("Wout", "Human")
                .makeAnimal("Arne", "Chimp")
                .makeAnimal("Tim", "Human")
                .makeAnimal("Tom", new Human())
                .makeAnimal("Sofie", new Chimp())
                .makeAnimal("Freddy", new Lion())
                .makeAnimal("George", new Gorilla());

        bananaTree.grow();

        AnimalInterface animal = animals.receiveAnimal(4L);
        System.out.println("The saved animal is: " + animal.name());
    }
}
