package com.tsi.AnimalKingdom.tests;

import com.tsi.AnimalKingdom.animals.birds.Pigeon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PigeonTest {

    @Test
    public void test_pigeon_breathing() {
        Pigeon p = new Pigeon();
        Assertions.assertEquals("carbon dioxide",p.breathe("oxygen"));
        Assertions.assertEquals(null,p.breathe("hydrogen"));
    }

    @Test
    public void test_pigeon_eating(){
        Pigeon p = new Pigeon();
        Assertions.assertTrue(p.eat("water"));
        Assertions.assertTrue(p.eat("seeds"));
        Assertions.assertTrue(p.eat("bread"));
        Assertions.assertFalse(p.eat("meat"));
    }

    @Test
    public void test_pigeon_takeFlight() {
        Pigeon p = new Pigeon();
        Assertions.assertTrue(p.takeFlight());
    }
    @Test
    public void test_pigeon_flight() {
        Pigeon p = new Pigeon();
        p.takeFlight();
        Assertions.assertTrue(p.flight(4, 2));
        Assertions.assertEquals(4, p.getPositionLat());
        Assertions.assertEquals(2, p.getPositionLong());
    }
    @Test
    public void test_pigeon_landing() {
        Pigeon p = new Pigeon();
        p.takeFlight();
        Assertions.assertTrue(p.landing());
    }
}
