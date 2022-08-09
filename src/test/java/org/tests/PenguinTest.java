package org.tests;

import org.example.Penguin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PenguinTest {
    @Test
    void test_penguin_eat() {

        Penguin p = new Penguin();
        Assertions.assertTrue(p.eat("water"));
        Assertions.assertTrue(p.eat("fish"));
        Assertions.assertFalse(p.eat("vegetables"));

    }

}
