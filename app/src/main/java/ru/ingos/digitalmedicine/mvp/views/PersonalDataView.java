package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface PersonalDataView extends MvpView {

    void setPersonalData(String fullName, String birthday, String numberInsurance, String jobPlace, String endInsurance, String phoneNumber);
    void updatePhone(String phone);
    @StateStrategyType(SkipStrategy.class)
    void showMessage(String message);
}
