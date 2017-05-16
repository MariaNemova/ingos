package ru.ingos.digitalmedicine.mvp.models;

public class DoctorStatsModel {

    private String nameDoctor;
    private String statsDoctor;

    public DoctorStatsModel(String nameDoctor, String description) {
        this.nameDoctor = nameDoctor;
        this.statsDoctor = description;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public String getStatsDoctor() {
        return statsDoctor;
    }
}
