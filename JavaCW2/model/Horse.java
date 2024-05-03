package model;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
