package org.example;

public class Cat extends Mammal{

    private int killCounter;

    public Cat() {
        this.killCounter = 0;
    }

    @Override
    public boolean eat(String food) {

        if (food.equals("water")) {
            // I can eat this
            return true;
        }
        if (food.equals("meat")) {
            // I can't eat this
            return true;
        }
        return false;
    }

    public void kill(Animal prey) {
        prey.die();
        killCounter++;
    }

    public int getKillCounter() {
        return killCounter;
    }
}
