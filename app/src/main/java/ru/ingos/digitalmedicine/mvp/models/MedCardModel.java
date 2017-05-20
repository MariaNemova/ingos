package ru.ingos.digitalmedicine.mvp.models;

import java.util.List;

public class MedCardModel {

    private String date;
    private String time;
    private String address;
    private String reports;
    private String diagnosis;
    private String docName;
    private List<String> recipes;

    public MedCardModel(String date, String time, String address, String reports, String diagnosis, String docName, List<String> recipes) {
        this.date = date;
        this.time = time;
        this.address = address;
        this.reports = reports;
        this.diagnosis = diagnosis;
        this.docName = docName;
        this.recipes = recipes;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getReports() {
        return reports;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDocName() {
        return docName;
    }

    public List<String> getRecipes() {
        return recipes;
    }
}
