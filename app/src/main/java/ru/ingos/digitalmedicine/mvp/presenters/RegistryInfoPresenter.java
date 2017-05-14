package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.mvp.views.RegistryInfoView;
import ru.ingos.digitalmedicine.ui.activities.ClinicInfoActivity;

@InjectViewState
public class RegistryInfoPresenter extends MvpPresenter<RegistryInfoView> {

    public void onClinicInfoClick(){
        getViewState().startChildActivity(ClinicInfoActivity.class);
    }

    public void onSpecialistClick(){
        //just do nothing
    }

    public void onConfirmRegistry(){
        getViewState().registryConfirmed();
    }

    public void onCancleRegistry(){
        getViewState().registryCanceled();
    }

}
