package ru.ingos.digitalmedicine.models;

/**
 * Created by Alexandr on 15.04.2017.
 */

public class ClinicModel {

    private String nameClinic;

    public ClinicModel(String name) {
        this.nameClinic = name;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public void setNameClinic(String nameClinic) {
        this.nameClinic = nameClinic;
    }
}
