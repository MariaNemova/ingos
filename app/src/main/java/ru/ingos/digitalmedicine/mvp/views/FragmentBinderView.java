package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SingleStateStrategy.class)
public interface FragmentBinderView extends MvpView{

    void bindFragmentSupport(Class fragmentClass, boolean addToBackStack);

}
