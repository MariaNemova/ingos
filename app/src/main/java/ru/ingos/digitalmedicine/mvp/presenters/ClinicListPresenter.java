package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.models.ClinicModel;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;

@InjectViewState
public class ClinicListPresenter extends MvpPresenter<ClinicListView> {


    private List<ClinicListModel> clinics;

        private List<ClinicListModel> loadClinics() {
        List<ClinicListModel> clinics = new ArrayList<>();
        clinics.add(new ClinicListModel("Будь здоров", "ул. Пушкина, д. 15"));
        clinics.add(new ClinicListModel("Клиника 2", "ул. Ленина, д. 22"));
        clinics.add(new ClinicListModel("Клиника 3", "ул. Васина, д. 41"));
        clinics.add(new ClinicListModel("Клиника 4", "ул. Петина, д. 67"));
        clinics.add(new ClinicListModel("Клиника 5", "ул. Иванова, д. 23"));
        clinics.add(new ClinicListModel("Клиника 6", "ул. Кек, д. 74"));
        clinics.add(new ClinicListModel("Клиника 7", "ул. Лел, д. 111"));

        return clinics;
    }

    @Override
    public void onFirstViewAttach() {
        Utils.logPresenterCreated(ClinicListPresenter.class);
        this.clinics = loadClinics();
        setClinics();
    }

    public void setClinics() {
        getViewState().setClinics(new ArrayList<>(clinics));
    }
}
