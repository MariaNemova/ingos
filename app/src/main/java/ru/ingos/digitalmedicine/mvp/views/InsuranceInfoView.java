package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

public interface InsuranceInfoView extends MvpView {


    void setInsuranceInfo(String name, String insuranceNumber, String insuranceDate);
}
