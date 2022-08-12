package com.tsi.AnimalKingdom.zoo;

import com.tsi.AnimalKingdom.animals.Animal;
import com.tsi.AnimalKingdom.animals.birds.Penguin;
import com.tsi.AnimalKingdom.animals.birds.Pigeon;
import com.tsi.AnimalKingdom.animals.mammals.Cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
public class Zoo {

    private int days;

    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<Animal>();
        this.days  = 0;
    }

    public void insertAnimal(Animal animal) {
        this.animals.add(animal);
    }
    public Animal getAnimal(int index) {
        return animals.get(index);
    }

    public List<Animal> getAnimalsList() {
        return this.animals;
    }

    public String toString() {
        String json = new Gson().toJson(this.animals);
        return json;
    }


    public void populateZoo() {
        Pigeon pigeon1 = new Pigeon();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Pigeon pigeon2 = new Pigeon();
        Penguin penguin = new Penguin();

//        for i in range
        Animal[] animals = {pigeon1, cat1, cat2, pigeon2, penguin};
        this.animals.addAll(Arrays.asList(animals));
    }
}
