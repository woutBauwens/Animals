package com.agfa.demo.domain;

import com.agfa.demo.domain.AnimalKingdom.Eats;
import com.agfa.demo.domain.PlantKingdom.Banana;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EatableTest {

    private Eats eats;
    private Eatable eatable;

    @Before
    public void setUp() {
        eats = new Eats();
    }

    @Test
    public void typeTest() {
        eatable = new Banana();
        assertEquals("Banana", eatable.type());
    }

    @Test
    public void eatsTest(){
        List<Eatable> eatableList = eats.start().eat("Banana").eat("Human").eat("Lion").build();
        assertEquals("Banana", eatableList.get(0).type());
        assertEquals("Human", eatableList.get(1).type());
        assertEquals("Lion", eatableList.get(2).type());
    }
}