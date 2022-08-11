package com.tsi.AnimalKingdom.animals;

import com.tsi.AnimalKingdom.animals.mammals.Bat;

public class Main {
    public static void main(String[] args) {
        Bat b = new Bat("Michael");
        b.takeFlight();
        System.out.println(b.getIsFlying());
    }
}
