package ru.ingos.digitalmedicine.mvp.models;

import android.graphics.drawable.Drawable;

public class InsuranceInfoModel {

    private String name;
    private String insuranceNumber;
    private String insuranceDate;
    private Drawable avatar;

    public InsuranceInfoModel(String name, String insuranceNumber, String insuranceDate, Drawable avatar) {
        this.name = name;
        this.insuranceNumber = insuranceNumber;
        this.insuranceDate = insuranceDate;
        this.avatar = avatar;
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

    public Drawable getAvatar() {
        return avatar;
    }
}
