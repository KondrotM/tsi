package org.tests;

import org.example.Bat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BatTest {
    Bat bat = new Bat();

    @Test
    public void test_bat_eat(){
        Assertions.assertTrue(bat.eat("vegetables"));
        Assertions.assertTrue(bat.eat("water"));
        Assertions.assertFalse(bat.eat("meat"));
    }

    @Test
    public void test_bat_flight(){

    }



}
