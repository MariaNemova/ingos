package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.views.FragmentBinderView;
import ru.ingos.digitalmedicine.ui.fragments.FragmentMain;

@InjectViewState
public class FragmentBinderPresenter extends MvpPresenter<FragmentBinderView> {

    private int session;

    @Override
    protected void onFirstViewAttach()
    {
        session = IngosApplication.GLOBAL_PREFERENCES.getInt(IngosApplication.PREF_SESSION_ID, -1);
        getViewState().bindFragmentSupport(FragmentMain.class, false);
    }

    public void bindFragment(Class fragmentClass, boolean addToBackStack){
        if(session == -1)
            getViewState().showAuthorizeActivity();

        if(fragmentClass == null){
            Log.w(IngosApplication.DEBUG_TAG, "Can't set fragment! Fragment is null!");
            return;
        }
        getViewState().bindFragmentSupport(fragmentClass, addToBackStack);
    }

}
