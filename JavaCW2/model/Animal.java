package model;

import java.time.LocalDate;

public abstract class Animal {
    private int id;
    private String name;
    private String type;
    private LocalDate dateOfBirth;
    private String commands;

    public Animal(int id, String name, String type, LocalDate dateOfBirth, String commands) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + type + " " + dateOfBirth + " " + commands;
    }
}
