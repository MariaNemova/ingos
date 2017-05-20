package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.views.FragmentBinderView;
import ru.ingos.digitalmedicine.ui.fragments.FragmentMain;

@InjectViewState
public class FragmentBinderPresenter extends MvpPresenter<FragmentBinderView> {

    @Override
    protected void onFirstViewAttach(){
        getViewState().bindFragmentSupport(FragmentMain.class, false);
    }

    public void bindFragment(Class fragmentClass, boolean addToBackStack){
        if(fragmentClass == null){
            Log.w(IngosApplication.DEBUG_TAG, "Can't set fragment! Fragment is null!");
            return;
        }
        getViewState().bindFragmentSupport(fragmentClass, addToBackStack);
    }

}
