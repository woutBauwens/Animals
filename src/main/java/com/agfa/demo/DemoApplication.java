package com.agfa.demo;

import com.agfa.demo.domain.AnimalKingdom.*;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.domain.PlantKingdom.Plant;
import com.agfa.demo.persistence.AnimalRepository;
import com.agfa.demo.persistence.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Animals animals = context.getBean(Animals.class);
		animals.makeAnimal("Wout", "Human")
				.makeAnimal("Arne", "Chimp")
				.makeAnimal("Tim", "Human")
				.makeAnimal("Tom", new Human())
				.makeAnimal("Sofie", new Chimp())
				.makeAnimal("Freddy", new Lion())
                .makeAnimal("George", new Gorilla());

		Plant bananatee = getBananaTree(context);
		bananatee.grow();

		AnimalRepository animalRepository = context.getBean(AnimalRepository.class);
		animalRepository.saveAll(animals);

		FoodRepository foodRepository = context.getBean(FoodRepository.class);
		foodRepository.saveFoodFromPlant(bananatee);

		AnimalInterface animal = animalRepository.receiveAnimal(new Long(4));
		System.out.println("The saved animal is: " + animal.name());
	}

	private static BananaTree getBananaTree(ConfigurableApplicationContext context){
		return context.getBean(BananaTree.class);
	}
}
