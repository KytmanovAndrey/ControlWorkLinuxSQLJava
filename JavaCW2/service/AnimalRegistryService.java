package service;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalRegistryService {
    private List<Animal> animals = new ArrayList<>();

    public void createAnimal(String name, String type, LocalDate dateOfBirth) {
        int maxId = 1;
        if (!animals.isEmpty()) {
            for (Animal animal : animals) {
                if (animal.getId() >= maxId) {
                    maxId = animal.getId() + 1;
                }
            }
        }
        if (type.equals("Dog")) {
            Dog dog = new Dog(maxId, name, type, dateOfBirth, "");
            dogs.add(dog);
            animals.add((Animal) dog);
        } else if (type.equals("Cat")) {
            Cat cat = new Cat(maxId, name, type, dateOfBirth, "");
            cats.add(cat);
            animals.add((Animal) cat);
        } else if (type.equals("Hamster")) {
            Hamster hamster = new Hamster(maxId, name, type, dateOfBirth, "");
            hamsters.add(hamster);
            animals.add((Animal) hamster);
        } else if (type.equals("Horse")) {
            Horse horse = new Horse(maxId, name, type, dateOfBirth, "");
            horses.add(horse);
            animals.add((Horse) horse);
        } else if (type.equals("Camel")) {
            Camel camel = new Camel(maxId, name, type, dateOfBirth, "");
            camels.add(camel);
            animals.add((Animal) camel);
        } else if (type.equals("Donkey")) {
            Donkey donkey = new Donkey(maxId, name, type, dateOfBirth, "");
            donkeys.add(donkey);
            animals.add((Animal) donkey);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
