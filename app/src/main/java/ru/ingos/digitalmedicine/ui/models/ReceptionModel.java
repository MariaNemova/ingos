package ru.ingos.digitalmedicine.ui.models;

public class ReceptionModel {

    private String docSpec;
    private String receptionDate;

    public ReceptionModel(String docName, String receptionDate) {
        this.docSpec = docName;
        this.receptionDate = receptionDate;
    }

    public String getDocSpec() {
        return docSpec;
    }

    public void setDocSpec(String docSpec) {
        this.docSpec = docSpec;
    }

    public String getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(String receptionDate) {
        this.receptionDate = receptionDate;
    }
}
