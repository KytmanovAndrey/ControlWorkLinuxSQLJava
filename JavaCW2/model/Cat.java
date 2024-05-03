package model;

import java.time.LocalDate;

public class Cat extends Pet{
    public Cat(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        super(id, name, type, dateOfBirth, commands);
    }
}
