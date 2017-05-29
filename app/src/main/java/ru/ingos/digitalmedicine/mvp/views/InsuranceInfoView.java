package ru.ingos.digitalmedicine.mvp.views;

import android.graphics.drawable.Drawable;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface InsuranceInfoView extends MvpView {


    void setInsuranceInfo(String name, String insuranceNumber, String insuranceDate, Drawable avatar);

    @StateStrategyType(SkipStrategy.class)
    void laodMethodsWithContext();
}
