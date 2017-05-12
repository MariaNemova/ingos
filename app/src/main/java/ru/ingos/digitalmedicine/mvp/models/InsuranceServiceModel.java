package ru.ingos.digitalmedicine.mvp.models;

public class InsuranceServiceModel {

    private String nameService;

    public InsuranceServiceModel(String nameService) {
        this.nameService = nameService;
    }

    public String getNameService() {
        return nameService;
    }
}
