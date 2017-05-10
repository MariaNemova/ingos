package ru.ingos.digitalmedicine.mvp.models;

public class SelectRegistryModel {

    private String NameSelect;
    private int icon;

    public SelectRegistryModel(String nameSelect, int icon) {
        NameSelect = nameSelect;
        this.icon = icon;
    }

    public String getNameSelect() {
        return NameSelect;
    }

    public int getIcon() {
        return icon;
    }
}
