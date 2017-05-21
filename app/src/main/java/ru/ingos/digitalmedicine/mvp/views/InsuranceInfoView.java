package ru.ingos.digitalmedicine.mvp.views;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.MvpView;

public interface InsuranceInfoView extends MvpView {


    void setInsuranceInfo(String name, String insuranceNumber, String insuranceDate, Drawable avatar);
}
