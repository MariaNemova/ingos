package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;

@StateStrategyType(SingleStateStrategy.class)
public interface FragmentBinderView extends MvpView{

    void bindFragmentSupport(Class fragmentClass, boolean addToBackStack);

}
