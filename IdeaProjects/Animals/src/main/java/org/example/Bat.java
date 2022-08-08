package org.example;

public class Bat extends Mammal implements Flying{

    private boolean isFlying;

    public Bat() {
        super();
        this.isFlying = false;
    }

    @Override
    public boolean eat(String food) {
        if (food.equals("vegetables")) {
            // I can eat this
            return true;
        }
        if (food.equals("water")) {
            // I can eat this
            return true;
        }
        return false;
    }

    @Override
    public boolean takeFlight() {
        isFlying = true;
        return true;
    }

    @Override
    public boolean flight() {
        return true;
    }

    @Override
    public boolean landing() {
        return true;
    }
}
