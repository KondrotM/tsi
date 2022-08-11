package com.tsi.AnimalKingdom.animals;

/**
 * The animal class is the base class for each animal in the animal kingdom.
 * Each animal implemented inherits base features from this class.
 */
public abstract class Animal {
    // Chance that breeding leads to birth.
    // This number requires professional evaluation.
    public static final float chanceOfConception = 0.4F;
    private boolean isAlive;
    private boolean isAwake;
    private float positionLat;
    private float positionLong;

    // The social name of the animal. By default it is the class name.
    private String name;

    // Whether the animal is pregnant and carrying a baby
    private boolean pregnant;
    private Animal animalBaby;

    protected Animal() {
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

    protected Animal(String name) {
        this.isAlive = true;
        this.isAwake = true;
        this.positionLat = 0;
        this.positionLong = 0;

        this.pregnant = false;
        this.animalBaby = null;

        this.name = name;
    }
    /**
     * Animal eats food. The condition as to whether or not it is eaten is if the animal can eat it.
     * All animals 'eat' water.
     * @param food the name, as a string, of the food being eaten.
     * @return boolean as to whether the food has been eaten.
     */
    public abstract boolean eat(String food);
    // breeds with partner

    /**
     * Animal breeds with another potential animal. If they are of compatible class there is a chance of conception.
     * Animals are not aware whether conception has occurred.
     * @param partner potential partner
     * @return whether breeding has occurred between the animals.
     */
    public abstract boolean breed(Animal partner);

    /**
     * Births a baby from a pregnant animal.
     * @return baby animal if pregnant, else returns null.
     */
    public abstract Animal birth();

    /**
     * Animal breathes molecules and attempts to respire from them.
     * @param molecule string of molecule breathed in
     * @return molecule breathed out.
     */
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

    /**
     * Directly sets location of an animal
     * Also sets location of baby if animal is pregnant.
     * @param lat latitude co-ordinate
     * @param lon longitude co-ordinate
     */
    public void setLocation(float lat, float lon) {
        this.positionLat = lat;
        this.positionLong = lon;

        if (isPregnant()) {
            this.animalBaby.setLocation(lat, lon);
        }
    }

    public boolean getAwake() {
        return this.isAwake;
    }

    /**
     * Increments current location of animal
     * Also moves baby if animal is pregnant.
     * @param lat latitude co-ordinate
     * @param lon longitude co-ordinate
     */
    public void move(float lat, float lon) {
        this.positionLat += lat;
        this.positionLong += lon;

        if (isPregnant()) {
            this.animalBaby.move(lat, lon);
        }
    }

    /**
     * Gives full position as a list of floats as a new object.
     * @return two floats {lat, lon}
     */
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
    }

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
