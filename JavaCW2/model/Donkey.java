package model;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
