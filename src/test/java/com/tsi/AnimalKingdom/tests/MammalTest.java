package com.tsi.AnimalKingdom.tests;

import com.tsi.AnimalKingdom.animals.birds.Bird;
import com.tsi.AnimalKingdom.animals.birds.Pigeon;
import com.tsi.AnimalKingdom.animals.mammals.Bat;
import com.tsi.AnimalKingdom.animals.mammals.Mammal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MammalTest {
    Mammal mam = new Bat();

    @Test
    public void test_mammal_breeding() {
        Mammal mate = new Bat();

        // breeding depends on random chance,
        // so we are testing for a balanced distribution
        int successfulMates = 0;
        for (int i = 0; i < 1000; i++) {
            mam.breed(mate);
            Mammal baby = mam.birth();
            if (baby != null) {
                successfulMates++;
            }
        }
        // 10% delta
        Assertions.assertEquals(successfulMates, 600, 100);
    }

    @Test
    public void test_mammal_cross_breeding() {
        Bird mate = new Pigeon();
        Assertions.assertEquals(mam.breed(mate), false);
    }

    @Test
    public void test_mammal_breathing() {
        Assertions.assertEquals("carbon dioxide",mam.breathe("oxygen"));
        Assertions.assertEquals(null,mam.breathe("hydrogen"));
    }


}
