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

import static org.junit.Assert.assertEquals;

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
       // assertEquals("Wout eats Bananas, Chimps", animalRepository.getAllAnimals().get(0).printString());
    }

    @Test
    public void isTypeTest(){
        Human human = new Human();
        Assert.assertTrue(human.is("Human"));
    }

    @Test
    public void eatsInitTest(){
        AnimalImpl chimp = new Chimp();
        Assert.assertTrue(chimp.eats().get(0).is("Banana"));
    }
}