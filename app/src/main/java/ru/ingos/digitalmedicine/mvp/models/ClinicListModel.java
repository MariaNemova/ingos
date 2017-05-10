package ru.ingos.digitalmedicine.mvp.models;

public class ClinicListModel {

    private String nameClinic;
    private String addresClinic;

    public ClinicListModel(String nameClinic, String addresClinic) {
        this.nameClinic = nameClinic;
        this.addresClinic = addresClinic;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public String getAddresClinic() {
        return addresClinic;
    }
}
