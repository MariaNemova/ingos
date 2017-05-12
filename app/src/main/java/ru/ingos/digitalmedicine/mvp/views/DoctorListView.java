package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.DoctorModel;

public interface DoctorListView extends MvpView {

    void setDoctors(List<DoctorModel> doctors);
}
