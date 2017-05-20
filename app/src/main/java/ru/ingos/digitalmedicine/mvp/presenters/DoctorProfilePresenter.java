package ru.ingos.digitalmedicine.mvp.presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.DoctorProfileModel;
import ru.ingos.digitalmedicine.mvp.views.DoctorProfileView;

@InjectViewState
public class DoctorProfilePresenter extends MvpPresenter<DoctorProfileView>{

    private DoctorProfileModel doctorProfile;

   private void loadDoctorProfile(){
       doctorProfile = new DoctorProfileModel("Иван Иванов",
               "Онколог",
               "30",
               "Институт имени Блаблабла",
               "7");
   }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(DoctorProfilePresenter.class);
        setDoctorProfile();
    }

    private void setDoctorProfile() {
        loadDoctorProfile();
        getViewState().setDoctorProfile(
                doctorProfile.getDocName(),
                doctorProfile.getDocSpeciality(),
                doctorProfile.getDocAge(),
                doctorProfile.getDocEducation(),
                doctorProfile.getDocExperience()
        );
    }
}
