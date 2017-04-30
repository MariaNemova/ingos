package ru.ingos.digitalmedicine.ui.models;

public class ClinicModel {

    private String nameClinic;
    private String addresClinic;

    public ClinicModel(String name, String addresClinic) {
        this.nameClinic = name;
        this.addresClinic = addresClinic;
    }

    public String getAddresClinic() {
        return addresClinic;
    }

    public void setAddresClinic(String addresClinic) {
        this.addresClinic = addresClinic;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public void setNameClinic(String nameClinic) {
        this.nameClinic = nameClinic;
    }
}
