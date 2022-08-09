package org.example;

import java.security.SecureRandom;

public abstract class Bird extends Animal {
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
    public boolean breed(Animal partner) {
        // Ensures both animals are in the same part of the animal kingdom
//        if (partner.getClass().getSuperclass().getName().equals(this.getClass().getSuperclass().getName())) {
        if(partner instanceof Bird) {
            try {
                Bird baby = this.getClass().getDeclaredConstructor().newInstance();

                // baby location is the same as the parent
                baby.setLocation(this.getPositionLat(), this.getPositionLong());

                // Secure random implementation, as recommended by SonarCloud
                SecureRandom random = new SecureRandom();
                byte bytes[] = new byte[20];
                random.nextBytes(bytes);

                if (random.nextFloat() > chanceOfConception) {
                    // parent is now pregnant
                    this.setPregnant(true);
                    this.setAnimalBaby(baby);
                }
                // breeding has occurred
                return true;

            } catch (Exception e) {
                // catch breeding exception
                return false;
            }
        } else {
            // i can't breed with this animal
            return false;
        }
    }

    public Bird birth() {
        if (this.isPregnant()) {
            this.setPregnant(false);
            Bird baby = (Bird) this.getAnimalBaby();

            this.setAnimalBaby(null);
            return baby;
        }
        return null;
    }
}
