package org.tests;

import org.example.Pigeon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PigeonTest {
    Pigeon p = new Pigeon();

    @Test
    void test_pigeon_breathing() {
        Assertions.assertEquals("carbon dioxide",p.breathe("oxygen"));
        Assertions.assertEquals(null,p.breathe("hydrogen"));
    }

    @Test
    void test_pigeon_eating(){
        Assertions.assertTrue(p.eat("water"));
        Assertions.assertTrue(p.eat("seeds"));
        Assertions.assertTrue(p.eat("bread"));
        Assertions.assertFalse(p.eat("meat"));
    }

    @Test
    void test_pigeon_takeFlight() {
        Assertions.assertTrue(p.takeFlight());
    }
    @Test
    void test_pigeon_flight() {
        Assertions.assertTrue(p.flight());
    }
    @Test
    void test_pigeon_landing() {
        Assertions.assertTrue(p.landing());
    }
}
