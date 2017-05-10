package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;

public interface ClinicListView extends MvpView {

    void setClinics(List<ClinicListModel> clinics);
}
