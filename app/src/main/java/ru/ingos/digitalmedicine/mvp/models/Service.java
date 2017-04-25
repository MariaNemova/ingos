package ru.ingos.digitalmedicine.mvp.models;

public class Service {

    private static int ID_COUNTER = 0;

    private String name;
    private String description;
    private int id;

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = ID_COUNTER;
        ID_COUNTER++;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
