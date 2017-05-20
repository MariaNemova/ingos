package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

public interface DoctorProfileView extends MvpView{
    void setDoctorProfile(String docName, String docSpeciality, String docAge, String docEducation, String docExperience);
}
