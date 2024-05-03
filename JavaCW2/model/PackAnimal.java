package model;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {
    public PackAnimal(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
