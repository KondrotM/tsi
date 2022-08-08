package org.example;

public abstract class Animal {

    boolean isAlive;
    boolean isAwake;
    float positionLat;
    float positionLong;

    public Animal() {
        isAlive = true;
        isAwake = true;
        positionLat = 0;
        positionLong = 0;
    }
    public abstract boolean eat(String food);
    public abstract void breed();
    public abstract String breathe(String molecule);

    public boolean getAlive() {
        return isAlive;
    }

    public boolean getAwake() {
        return isAwake;
    }
    public void move(float lat, float lon) {
        positionLat += lat;
        positionLong += lon;
    }

    public float[] getPosition() {
        return new float[]{this.positionLat, this.positionLong};
    }

    public void sleep() {
        this.isAwake = false;
    }

    public void awake() {
        this.isAwake = true;
    }

    /* Spicy sleep function, only works if each animal has its own thread
    public void sleep(int time) throws InterruptedException {
        Object sleep = new Object();
        sleep.wait(time);
    } */

    public boolean poop(){
        return true;
    };

    public void die(){
        isAlive = false;
    }
}
