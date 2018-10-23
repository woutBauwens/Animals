package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.domain.PlantKingdom.Banana;
import com.agfa.demo.domain.PlantKingdom.BananaTree;
import com.agfa.demo.persistence.AnimalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AnimalTest extends Animal {

    AnimalRepository animalRepository;

    @Before
    public void setUp() throws Exception {
        animalRepository = new AnimalRepository();
    }

    @Test
    public void makeNewAnimal(){
      //  animalRepository.makeAnimal("Wout", new Human());
      //  assertEquals("Wout eats Bananas, Chimps", animalRepository.getAllAnimals().get(0).printLine());
    }

    @Test
    public void isType(){
        Human human = new Human();
        Assert.assertTrue(human.is("Human"));
    }

    @Test
    public void eatsInit(){
        Animal chimp = new Chimp();
        Assert.assertEquals(Arrays.asList(new Food[]{new Banana()}).toString(), chimp.eats().toString());
    }
}