package org.example;

public abstract class Animal {

    // Chance that breeding leads to birth.
    // This number requires professional evaluation.
    public static float chanceOfConception = 0.4F;
    private boolean isAlive;
    private boolean isAwake;
    private float positionLat;
    private float positionLong;

    private String name;


    private boolean pregnant;
    private Animal animalBaby;

    public Animal() {
        this.isAlive = true;
        this.isAwake = true;
        this.positionLat = 0;
        this.positionLong = 0;

        this.pregnant = false;
        this.animalBaby = null;

        // Gives default name
        String orgName = getClass().getName();
        this.name = orgName.substring(orgName.lastIndexOf(".") + 1);
    }

    public Animal(String name) {
        this.isAlive = true;
        this.isAwake = true;
        this.positionLat = 0;
        this.positionLong = 0;

        this.pregnant = false;
        this.animalBaby = null;

        this.name = name;
    }
    public abstract boolean eat(String food);
    // breeds with partner
    public abstract boolean breed(Animal partner);
    public abstract Animal birth();
    public abstract String breathe(String molecule);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public Animal getAnimalBaby() {
        return animalBaby;
    }

    public void setAnimalBaby(Animal animalBaby) {
        this.animalBaby = animalBaby;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setLocation(float lat, float lon) {
        this.positionLat = lat;
        this.positionLong = lon;
    }


    public boolean getAwake() {
        return this.isAwake;
    }
    public void move(float lat, float lon) {
        this.positionLat += lat;
        this.positionLong += lon;

        if (this.pregnant) {
            this.animalBaby.move(lat, lon);
        }
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

    public float getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(float positionLat) {
        this.positionLat = positionLat;
    }

    public float getPositionLong() {
        return positionLong;
    }

    public void setPositionLong(float positionLong) {
        this.positionLong = positionLong;
    }
}
