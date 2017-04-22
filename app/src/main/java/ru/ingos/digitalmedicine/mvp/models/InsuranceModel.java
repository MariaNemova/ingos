package ru.ingos.digitalmedicine.mvp.models;

import java.util.Date;

public class InsuranceModel{

    private String userName;
    private String userSurname;
    private Date expireDate;

    public InsuranceModel(String userName, String userSurname, Date expireDate) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.expireDate = expireDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
