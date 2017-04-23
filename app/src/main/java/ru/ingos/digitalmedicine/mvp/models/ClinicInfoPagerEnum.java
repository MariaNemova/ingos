package ru.ingos.digitalmedicine.mvp.models;

import ru.ingos.digitalmedicine.R;

public enum ClinicInfoPagerEnum {

    SHORT_INFO(R.layout.fragment_layout_private_room),
    WORK_LIST(R.layout.fragment_layout_private_room),
    REPLICES(R.layout.fragment_layout_private_room);

    private int layout_pointer;

    ClinicInfoPagerEnum(int layout_pointer){
        this.layout_pointer = layout_pointer;
    }

    public int getLayoutPointer() {
        return layout_pointer;
    }
}
