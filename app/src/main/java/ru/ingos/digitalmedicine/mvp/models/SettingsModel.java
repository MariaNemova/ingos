package ru.ingos.digitalmedicine.mvp.models;

public class SettingsModel {

    private String nameSetting;
    private int icon;


    public SettingsModel(String nameSetting, int icon) {
        this.nameSetting = nameSetting;
        this.icon = icon;
    }

    public String getNameSetting() {
        return nameSetting;
    }

    public int getIcon() {
        return icon;
    }
}
