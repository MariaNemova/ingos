package ru.ingos.digitalmedicine.mvp.models;



public class DoctorProfileModel {

    private String docName;
    private String docSpeciality;
    private String docAge;
    private String docEducation;
    private String docExperience;

    public DoctorProfileModel(String docName, String docSpeciality, String docAge, String docEducation, String docExperience) {
        this.docName = docName;
        this.docSpeciality = docSpeciality;
        this.docAge = docAge;
        this.docEducation = docEducation;
        this.docExperience = docExperience;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocSpeciality() {
        return docSpeciality;
    }

    public String getDocAge() {
        return docAge;
    }

    public String getDocEducation() {
        return docEducation;
    }

    public String getDocExperience() {
        return docExperience;
    }
}
