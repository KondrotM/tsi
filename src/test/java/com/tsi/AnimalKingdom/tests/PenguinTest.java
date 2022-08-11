package com.tsi.AnimalKingdom.tests;

import com.tsi.AnimalKingdom.animals.birds.Penguin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PenguinTest {
    @Test
    public void test_penguin_eat() {

        Penguin p = new Penguin();
        Assertions.assertTrue(p.eat("water"));
        Assertions.assertTrue(p.eat("fish"));
        Assertions.assertFalse(p.eat("vegetables"));

    }

}
