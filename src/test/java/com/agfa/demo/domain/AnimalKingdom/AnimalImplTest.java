package com.agfa.demo.domain.AnimalKingdom;

import com.agfa.demo.persistence.AnimalEntity;
import com.agfa.demo.persistence.AnimalRepository;
import com.agfa.demo.persistence.AnimalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnimalImplTest extends AnimalImpl {

    @InjectMocks
    AnimalRepository animalRepository;

    @Mock
    AnimalService service;

    @Mock
    AnimalEntity entity;

    @Before
    public void setUp() {
    }

    @Test
    public void makeNewAnimalTest(){
        animalRepository.makeAnimal("Wout", new Human());
       // assertEquals("Wout eats Bananas, Chimps", animalRepository.getAllAnimals().asFood(0).printString());
    }

    @Test
    public void isTypeTest(){
        Human human = new Human();
        Assert.assertTrue(human.is("Human"));
    }

    @Test
    public void eatsInitTest(){
        AnimalImpl chimp = new Chimp();
        Assert.assertTrue(chimp.getFood().get(0).is("Banana"));
    }

    @Override
    public void addAsFood() {

    }
}