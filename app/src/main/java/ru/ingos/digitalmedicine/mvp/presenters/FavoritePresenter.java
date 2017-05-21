package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.views.FavoriteView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class FavoritePresenter  extends MvpPresenter<FavoriteView>{

    private List<String> doctors = new ArrayList<>();
    private List<ClinicListModel> clinics = new ArrayList<>();


    @Override
    public void onFirstViewAttach(){
        setFavoriteClinics();
        setFavoriteDoctors();

        doctors.add("Иванов Иван Иванович");
        doctors.add("Петров Петр Петрович");
        doctors.add("Николаев Николай Николаевич");
    }

    public void setFavoriteClinics(){
        if(clinics.size() != 0)
            getViewState().setClinics(clinics);
    }

    public void setFavoriteDoctors(){
        getViewState().setDoctors(new ArrayList<String>(doctors));
    }

    public void refreshClinics(){
        clinics = new ArrayList<>();
        for(int i=0;i<IngosApplication.FAVORITE_CLINICS_COUNT;i++){
            clinics.add(new ClinicListModel("Любимая клинка", "ул. Тестовая, 11/1"));
        }
        setFavoriteClinics();
    }

}
