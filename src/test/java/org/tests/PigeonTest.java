package org.tests;

import org.example.Pigeon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PigeonTest {
    Pigeon p = new Pigeon();

    @Test
    public void test_pigeon_breathing() {
        Assertions.assertEquals("carbon dioxide",p.breathe("oxygen"));
        Assertions.assertEquals(null,p.breathe("hydrogen"));
    }

    @Test
    public void test_pigeon_eating(){
        Assertions.assertTrue(p.eat("water"));
        Assertions.assertTrue(p.eat("seeds"));
        Assertions.assertTrue(p.eat("bread"));
        Assertions.assertFalse(p.eat("meat"));
    }

    @Test
    public void test_pigeon_takeFlight() {
        Assertions.assertTrue(p.takeFlight());
    }
    @Test
    public void test_pigeon_flight() {
        Assertions.assertTrue(p.flight());
    }
    @Test
    public void test_pigeon_landing() {
        Assertions.assertTrue(p.landing());
    }
}
