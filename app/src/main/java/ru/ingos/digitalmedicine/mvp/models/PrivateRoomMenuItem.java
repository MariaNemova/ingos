package ru.ingos.digitalmedicine.mvp.models;

public class PrivateRoomMenuItem {

    private String name;
    private String description;
    private int icon_pointer;

    public PrivateRoomMenuItem(String name, String description, int icon_pointer) {
        this.name = name;
        this.description = description;
        this.icon_pointer = icon_pointer;
    }

    public String getItemName() {
        return name;
    }

    public String getItemDescription() {
        return description;
    }

    public int getItemIconPointer() {
        return icon_pointer;
    }
}
