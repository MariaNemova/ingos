package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface AuthView extends MvpView{

    void successfulAuthorization();
    void showMessage(String message);

}
