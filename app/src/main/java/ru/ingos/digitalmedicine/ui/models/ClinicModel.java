package ru.ingos.digitalmedicine.ui.models;

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
