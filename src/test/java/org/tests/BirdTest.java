package org.tests;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirdTest {
    Bird b = new Pigeon();

    @Test
    public void test_bird_breathing() {
        Assertions.assertEquals("carbon dioxide",b.breathe("oxygen"));
        Assertions.assertEquals(null,b.breathe("hydrogen"));
    }

    @Test
    public void test_bird_breeding() {
        Bird mate = new Pigeon();

        // breeding depends on random chance,
        // so we are testing for a balanced distribution
        int successfulMates = 0;
        for (int i = 0; i < 1000; i++) {
            b.breed(mate);
            Bird baby = b.birth();
            if (baby != null) {
                successfulMates++;
            }
        }
        // 10% delta
        Assertions.assertEquals(successfulMates, 600, 100);
    }

    @Test
    public void test_mammal_cross_breeding() {
        Mammal mate = new Cat();
        Assertions.assertEquals(b.breed(mate), false);
    }



}
