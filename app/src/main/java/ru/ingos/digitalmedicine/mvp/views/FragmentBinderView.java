package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


public interface FragmentBinderView extends MvpView{

    @StateStrategyType(SingleStateStrategy.class)
    void bindFragmentSupport(Class fragmentClass, boolean addToBackStack);
    void showAuthorizeActivity();

}
