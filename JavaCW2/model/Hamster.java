package model;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
