package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainMenuView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void replaceCheck(int num);

}
