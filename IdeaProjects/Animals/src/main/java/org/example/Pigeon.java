package org.example;

public class Pigeon extends Bird implements Flying{
    @Override
    public boolean eat(String food) {
        if (food.equals("water")) {
            return true;
        }
        if (food.equals("seeds")) {
            return true;
        }
        if (food.equals("bread")) {
            return true;
        }
        // i can't eat much else;
        return false;
    }

    @Override
    public boolean takeFlight() {
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
