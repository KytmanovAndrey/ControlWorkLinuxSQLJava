package model;

import java.time.LocalDate;

public abstract class Pet extends Animal {
    public Pet(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
