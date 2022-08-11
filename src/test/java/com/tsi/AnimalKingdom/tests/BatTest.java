package com.tsi.AnimalKingdom.tests;

import com.tsi.AnimalKingdom.animals.mammals.Bat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BatTest {

    @Test
    public void test_bat_name_constructor(){
        Bat b = new Bat("Lewis");
        Assertions.assertEquals("Lewis", b.getName());
    }

    @Test
    public void test_bat_eat(){
        Bat b = new Bat();
        Assertions.assertTrue(b.eat("vegetables"));
        Assertions.assertTrue(b.eat("water"));
        Assertions.assertFalse(b.eat("meat"));
    }

    @Test
    public void test_bat_takeFlight() {
        Bat b = new Bat();
        Assertions.assertTrue(b.takeFlight());
    }
    @Test
    public void test_bat_flight() {
        Bat b = new Bat();
        b.takeFlight();
        Assertions.assertTrue(b.flight(4, 2));
        Assertions.assertEquals(4, b.getPositionLat());
        Assertions.assertEquals(2, b.getPositionLong());
    }
    @Test
    public void test_bat_landing() {
        Bat b = new Bat();
        b.takeFlight();
        Assertions.assertTrue(b.landing());
    }



}
