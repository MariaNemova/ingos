package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;
import ru.ingos.digitalmedicine.mvp.views.InsuranceServicesView;

@InjectViewState
public class InsuranceServicesPresenter extends MvpPresenter<InsuranceServicesView> {

    List<InsuranceServiceModel> insuranceServices;

    private List<InsuranceServiceModel> loadInsuranceServices() {
        List<InsuranceServiceModel> insuranceServices = new ArrayList<>();

        insuranceServices.add(new InsuranceServiceModel("Услуга 1"));
        insuranceServices.add(new InsuranceServiceModel("Услуга 2"));
        insuranceServices.add(new InsuranceServiceModel("Услуга 3"));
        insuranceServices.add(new InsuranceServiceModel("Услуга 4"));

        return insuranceServices;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(InsuranceServicesPresenter.class);
        this.insuranceServices = loadInsuranceServices();
        setInsuranceServices();
    }

    public void setInsuranceServices() {
        getViewState().setInsuranceServices(new ArrayList<>(insuranceServices));
    }
}
