package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;

public interface InsuranceServicesView extends MvpView {

    void setInsuranceServices(List<InsuranceServiceModel> insuranceServices);

}
