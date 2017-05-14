package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.PersonalDataModel;
import ru.ingos.digitalmedicine.mvp.views.PersonalDataView;

@InjectViewState
public class PersonalDataPresenter extends MvpPresenter<PersonalDataView> {

    private PersonalDataModel personalData;

    private void loadPersonalData(){
        personalData = new PersonalDataModel("Иванов Иван Иванович",
                "19.11.1996",
                "12345",
                "Ингосстрах",
                "19.11.2020",
                "+79521135234");
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(PersonalDataPresenter.class);
        setPersonalData();
    }

    public void setPersonalData() {
        loadPersonalData();
        getViewState().setPersonalData(
                personalData.getFullName(),
                personalData.getBirthday(),
                personalData.getNumberInsurance(),
                personalData.getJobPlace(),
                personalData.getEndInsurance(),
                personalData.getPhoneNumber()
        );
    }
}
