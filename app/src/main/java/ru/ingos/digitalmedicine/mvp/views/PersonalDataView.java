package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

public interface PersonalDataView extends MvpView {

    void setPersonalData(String fullName, String birthday, String numberInsurance, String jobPlace, String endInsurance, String phoneNumber);
}
