package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.persistence.PlantService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BananaTreeTest {

    String name;

    @InjectMocks
    BananaTree treeMock;

    @Mock PlantService service;
    @Mock EntityManager manager;

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp(){
        name = "TEST";
    }

    @Test
    public void growTest() {
        treeMock.grow(1);
        //assertEquals(1,  treeMock.getTree().size());
    }

    @Test
    public void weedSeedTest() {
        assertNotEquals(name, treeMock.name);
        treeMock.weedSeed(name);
        assertEquals(name, treeMock.name);
    }

    @Test
    public void newBananaTest() {
        Banana banana = new Banana(treeMock.name);
        assertEquals(treeMock.name, banana.parent());
    }
}