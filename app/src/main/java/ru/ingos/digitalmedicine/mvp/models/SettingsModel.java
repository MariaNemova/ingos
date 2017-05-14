package ru.ingos.digitalmedicine.mvp.models;

public class SettingsModel {

    private String nameSetting;

    public SettingsModel(String nameSetting) {
        this.nameSetting = nameSetting;
    }

    public String getNameSetting() {
        return nameSetting;
    }
}
