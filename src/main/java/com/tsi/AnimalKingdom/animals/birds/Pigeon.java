package com.tsi.AnimalKingdom.animals.birds;

import com.tsi.AnimalKingdom.animals.interfaces.Flying;

public class Pigeon extends Bird implements Flying {

    private boolean isFlying;

    public Pigeon() {
        super();
        this.isFlying = false;
    }
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
