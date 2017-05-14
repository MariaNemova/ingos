package ru.ingos.digitalmedicine.mvp.models;

public class PersonalDataModel {

    private String fullName;
    private String birthday;
    private String numberInsurance;
    private String jobPlace;
    private String endInsurance;
    private String phoneNumber;

    public PersonalDataModel(String fullName, String birthday, String numberInsurance, String jobPlace, String endInsurance, String phoneNumber) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.numberInsurance = numberInsurance;
        this.jobPlace = jobPlace;
        this.endInsurance = endInsurance;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNumberInsurance() {
        return numberInsurance;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public String getEndInsurance() {
        return endInsurance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
