package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.DoctorStatsModel;

public interface DoctorStatsView extends MvpView {

    void setDoctorStats(List<DoctorStatsModel> doctorStats);
}
