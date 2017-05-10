package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface HomeView extends MvpView{

    void setLastClinicInfo(String name, String adress, String phone, String workHours);
    void setInsuranceInfo(String userName, String expire, Boolean isRed);

    @StateStrategyType(SkipStrategy.class)
    void showPrivateRoom();
    @StateStrategyType(SkipStrategy.class)
    void showStatistics();
    @StateStrategyType(SkipStrategy.class)
    void createNewRegistry();
    @StateStrategyType(SkipStrategy.class)
    void showClinicsList();
    @StateStrategyType(SkipStrategy.class)
    void showClinicInfo();
    @StateStrategyType(SkipStrategy.class)
    void showRegistryList();
    @StateStrategyType(SkipStrategy.class)
    void showRecipeList();
}
