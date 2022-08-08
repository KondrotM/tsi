package org.tests;

import org.example.Animal;
import org.example.Bat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    // Non-abstract animal class called
    Animal an = new Bat();

    @Test
    public void test_animal_alive() {

        Assertions.assertTrue(an.getAlive());
        an.die();
        Assertions.assertFalse(an.getAlive());
    }

    @Test
    public void test_animal_move_long() {

        Assertions.assertEquals(0, an.getPosition()[1]);

        an.move(0, 2.5F);

        Assertions.assertEquals(1.5F, an.getPosition()[0]);
    }

    @Test
    public void test_animal_move_lat() {

        Assertions.assertEquals(0, an.getPosition()[1]);

        an.move(1.5F, 0);

        Assertions.assertEquals(1.5F, an.getPosition()[0]);
    }

    @Test
    public void test_animal_move_lat_long() {
        Assertions.assertEquals(0, an.getPosition()[0]);
        Assertions.assertEquals(0, an.getPosition()[1]);

        an.move(1.5F, 2.5F);

        Assertions.assertEquals(1.5F, an.getPosition()[0]);
        Assertions.assertEquals(2.5F, an.getPosition()[1]);
    }

    @Test
    public void test_animal_sleep() {
        Assertions.assertTrue(an.getAwake());
        an.sleep();
        Assertions.assertFalse(an.getAwake());
        an.awake();
        Assertions.assertTrue(an.getAwake());
    }

    @Test
    public void test_animal_poop() {
        Assertions.assertTrue(an.poop());
    }

}
