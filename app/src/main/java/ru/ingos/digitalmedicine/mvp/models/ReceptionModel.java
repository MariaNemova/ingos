package ru.ingos.digitalmedicine.mvp.models;

public class ReceptionModel {

    private String docSpec;
    private String receptionDate;

    public ReceptionModel(String docSpec, String receptionDate) {
        this.docSpec = docSpec;
        this.receptionDate = receptionDate;
    }

    public String getDocSpec() {
        return docSpec;
    }

    public String getReceptionDate() {
        return receptionDate;
    }
}
