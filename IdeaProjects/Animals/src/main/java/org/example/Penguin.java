package org.example;

public class Penguin extends Bird {

    @Override
    public boolean eat(String food) {
       if (food.equals("water")) {
           return true;
       }
        if (food.equals("fish")) {
            return true;
        }
        return false;
    }

}
