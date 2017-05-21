package ru.ingos.digitalmedicine.mvp.models;

public class InsuranceInfoModel {

    private String name;
    private String insuranceNumber;
    private String insuranceDate;

    public InsuranceInfoModel(String name, String insuranceNumber, String insuranceDate) {
        this.name = name;
        this.insuranceNumber = insuranceNumber;
        this.insuranceDate = insuranceDate;
    }

    public String getName() {
        return name;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }
}
