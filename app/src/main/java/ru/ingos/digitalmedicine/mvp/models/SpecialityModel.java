package ru.ingos.digitalmedicine.mvp.models;

public class SpecialityModel {

    private static int ID_COUNTER = 0;

    private String nameSpec;

    public SpecialityModel(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    public String getNameSpec() {
        return nameSpec;
    }

}
