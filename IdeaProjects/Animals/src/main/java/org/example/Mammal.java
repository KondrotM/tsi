package org.example;

public abstract class Mammal extends Animal {
    @Override
    public String breathe(String molecule) {
        if (molecule.equals("oxygen")){
            return "carbon dioxide";
        } else {
            // i can't breathe this
            return null;
        }
    }

    @Override
    public void breed() {

    }
}
