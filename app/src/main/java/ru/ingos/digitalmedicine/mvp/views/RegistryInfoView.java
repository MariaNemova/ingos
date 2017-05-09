package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RegistryInfoView extends MvpView{

    @StateStrategyType(SkipStrategy.class)
    void registryCanceled();
    @StateStrategyType(SkipStrategy.class)
    void startChildActivity(Class<? extends MvpAppCompatActivity> activityClass);

}
