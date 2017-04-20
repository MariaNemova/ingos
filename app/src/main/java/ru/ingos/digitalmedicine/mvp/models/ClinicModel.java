package ru.ingos.digitalmedicine.mvp.models;

public class ClinicModel {

    private String clinicName;
    private String clinicPhone;
    private String clinicWorkHours;

    private String city;
    private String street;
    private int houseNum;
    private int buildingNum;

    public ClinicModel(String clinicName, String clinicPhone, String clinicWorkHours, String city, String street, int houseNum, int buildingNum) {
        this.clinicName = clinicName;
        this.clinicPhone = clinicPhone;
        this.clinicWorkHours = clinicWorkHours;
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
        this.buildingNum = buildingNum;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicPhone() {
        return clinicPhone;
    }

    public String getClinicWorkHours() {
        return clinicWorkHours;
    }

    public String getClinincFullAdress(){
        return "г."+city+", ул."+street+", "+houseNum+"/"+buildingNum;
    }

    public String getClinincAdress(){
        return "ул."+street+", "+houseNum+"/"+buildingNum;
    }
}
