package org.tests;

import org.example.Bird;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirdTest {
    Bird b = new Bird() {
        @Override
        public boolean eat(String food) {
            return false;
        }
    };

    @Test
    public void test_bird_breathing() {
        Assertions.assertEquals("carbon dioxide",b.breathe("oxygen"));
        Assertions.assertEquals(null,b.breathe("hydrogen"));
    }



}
