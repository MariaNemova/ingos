package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.DoctorStatsModel;
import ru.ingos.digitalmedicine.mvp.views.DoctorStatsView;

@InjectViewState
public class DoctorStatsPresenter extends MvpPresenter<DoctorStatsView> {

    List<DoctorStatsModel> doctorStats;

    private List<DoctorStatsModel> loadDoctorStats(){
        List<DoctorStatsModel> doctorStats = new ArrayList<>();

        doctorStats.add(new DoctorStatsModel("ЛОР", "2 раза"));
        doctorStats.add(new DoctorStatsModel("Хирург", "1 раз"));
        doctorStats.add(new DoctorStatsModel("Терапевт", "3 раза"));
        doctorStats.add(new DoctorStatsModel("Окулист", "1 раз"));

        return doctorStats;
    }


    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(DoctorStatsPresenter.class);
        this.doctorStats = loadDoctorStats();
        setDoctorStats();
    }

    private void setDoctorStats() {
        getViewState().setDoctorStats(new ArrayList<>(doctorStats));
    }
}
