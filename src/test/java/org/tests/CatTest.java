package org.tests;

import org.example.Cat;
import org.example.Pigeon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CatTest {

    @Test
    void test_get_cat_killer() {
        Cat testCat = new Cat();
        Pigeon prey = new Pigeon();

        testCat.kill(prey);

        Assertions.assertFalse(prey.getAlive());
        Assertions.assertEquals(1, testCat.getKillCounter());
    }

    @Test
    void test_cat_eat() {
        Cat cat = new Cat();

        Assertions.assertTrue(cat.eat("water"));
        Assertions.assertTrue(cat.eat("meat"));
        Assertions.assertFalse(cat.eat("vegetables"));
    }
}

