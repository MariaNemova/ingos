package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;

import java.util.List;

public interface FavoriteView extends MvpView {

    void setClinics(List<ClinicListModel> clinics);
    void setDoctors(List<String> doctors);

}
