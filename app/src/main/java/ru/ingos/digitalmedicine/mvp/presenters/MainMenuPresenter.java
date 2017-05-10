package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.mvp.views.MainMenuView;
import ru.ingos.digitalmedicine.ui.fragments.*;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class MainMenuPresenter extends MvpPresenter<MainMenuView> {

    private static List<Class<? extends MvpFragment>> sFragmentClassesList = new ArrayList<>();

    @Override
    public void onFirstViewAttach(){
        MainMenuPresenter.loadClassNames();
        getViewState().replaceCheck(0);
    }

    public void changeSelection(Class<? extends MvpFragment> fragmentClass){
        if(!MainMenuPresenter.sFragmentClassesList.contains(fragmentClass)) {
            getViewState().replaceCheck(-1);
        }else {
            getViewState().replaceCheck(MainMenuPresenter.sFragmentClassesList.indexOf(fragmentClass));
        }
    }

    public void diselectAll(){
        getViewState().replaceCheck(-1);
    }

    private static void loadClassNames(){
        if(MainMenuPresenter.sFragmentClassesList.size()>0) return;
        MainMenuPresenter.sFragmentClassesList.add(FragmentMain.class);
        MainMenuPresenter.sFragmentClassesList.add(FragmentHistory.class);
        MainMenuPresenter.sFragmentClassesList.add(FragmentClinicList.class);
        MainMenuPresenter.sFragmentClassesList.add(FragmentRegistry.class);
        MainMenuPresenter.sFragmentClassesList.add(FragmentRecipes.class);
        MainMenuPresenter.sFragmentClassesList.add(FragmentSettings.class);
    }


    
}
