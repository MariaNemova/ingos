package ru.ingos.digitalmedicine.mvp.presenters;

import android.support.annotation.Nullable;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.views.DoctorListView;

@InjectViewState
public class DoctorListPresenter extends MvpPresenter<DoctorListView> {

    private List<DoctorModel> doctors;

    private List<DoctorModel> loadDoctors(){
        List<DoctorModel> doctors = new ArrayList<>();

        doctors.add(new DoctorModel("Иванов Иван Иваныч"));
        doctors.add(new DoctorModel("Петрова Светлана Николаевна"));
        doctors.add(new DoctorModel("Петечекин Борис Федорович"));
        doctors.add(new DoctorModel("Борцов Петр Александрович"));

        return doctors;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(DoctorListPresenter.class);

    }

    public void loadDoctors(boolean all, @Nullable String clinicName){
        if(all){
            this.doctors = loadDoctors();
        }
    }

    public void setDoctors() {
        getViewState().setDoctors(new ArrayList<>(doctors));
    }
}
