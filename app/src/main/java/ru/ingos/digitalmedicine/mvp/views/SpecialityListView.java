package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.SpecialityModel;

public interface SpecialityListView extends MvpView {

    void setSpecialties(List<SpecialityModel> specialties);
}
