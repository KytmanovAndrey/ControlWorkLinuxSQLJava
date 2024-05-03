package model;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
