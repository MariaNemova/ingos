package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.SpecialityModel;
import ru.ingos.digitalmedicine.mvp.views.SpecialityListView;

@InjectViewState
public class SpecialityListPresenter extends MvpPresenter<SpecialityListView> {

    List<SpecialityModel> specialties;

    private List<SpecialityModel> loadSpecialties(){
        List<SpecialityModel> specialties = new ArrayList<>();

        specialties.add(new SpecialityModel("Терапевт"));
        specialties.add(new SpecialityModel("Ортопед"));
        specialties.add(new SpecialityModel("Гематолог"));
        specialties.add(new SpecialityModel("Логопед"));
        specialties.add(new SpecialityModel("ЛОР"));
        specialties.add(new SpecialityModel("Онколог"));
        specialties.add(new SpecialityModel("Хирург"));

        return specialties;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(SpecialityListPresenter.class);
        this.specialties = loadSpecialties();
        setSpecialties();

    }

    public void setSpecialties() {
        getViewState().setSpecialties(new ArrayList<>(specialties));
    }
}
