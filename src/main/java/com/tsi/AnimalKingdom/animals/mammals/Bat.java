package com.tsi.AnimalKingdom.animals.mammals;

import com.tsi.AnimalKingdom.animals.interfaces.Flying;

public class Bat extends Mammal implements Flying {

    private boolean isFlying;

    public Bat() {
        super();
        this.isFlying = false;
    }

    public Bat(String name) {
        super(name);
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
        if (!getIsFlying()) {
            setFlying(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean flight(long lat, long lon) {
        if (this.getIsFlying()) {
            this.move(lat, lon);
            return true;
        }  else {
            return false;
        }
    }

    @Override
    public boolean landing() {
        if (getIsFlying()) {
            setFlying(false);
            return true;
        } else {
            return false;
        }
    }
    public boolean getIsFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

}
