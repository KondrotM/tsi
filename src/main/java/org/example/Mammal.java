package org.example;

import java.security.SecureRandom;

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
    public boolean breed(Animal partner) {
        // Ensures both animals are in the same part of the animal kingdom
//        if (partner.getClass().getSuperclass().getName().equals(this.getClass().getSuperclass().getName())) {
        if(partner instanceof Mammal) {
            try {
                Mammal baby = this.getClass().getDeclaredConstructor().newInstance();

                // baby location is the same as the parent
                baby.setLocation(this.getPositionLat(), this.getPositionLong());

                // chance for pregnancy
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
                return false;
                // catch breeding exception
            }
        } else {
            return false;
            // i can't breed with this animal
        }
    }

    @Override
    public Mammal birth() {
        if (this.isPregnant()) {
            this.setPregnant(false);
            Mammal baby = (Mammal) this.getAnimalBaby();

            this.setAnimalBaby(null);
            return baby;
        }
        return null;
    }
}
