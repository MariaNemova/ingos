package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.mvp.views.FragmentBinderView;
import ru.ingos.digitalmedicine.ui.fragments.FragmentMain;

@InjectViewState
public class FragmentBinderPresenter extends MvpPresenter<FragmentBinderView> {

    @Override
    protected void onFirstViewAttach(){
//        Log.d("MOJAR" , "First atttach!");
        getViewState().bindFragment(FragmentMain.class, false);
    }

    public void bindFragment(Class<? extends MvpFragment> fragmentClass, boolean addToBackStack){
        if(fragmentClass == null){
            Log.w("MOJAR", "Can't set fragment! Fragment is null!");
            return;
        }
//        Log.d("MOJAR", "FragmentBinded");
        getViewState().bindFragment(fragmentClass, addToBackStack);
    }

}
