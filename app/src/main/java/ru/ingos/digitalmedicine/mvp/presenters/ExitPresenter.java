package ru.ingos.digitalmedicine.mvp.presenters;

import android.content.SharedPreferences;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.views.ExitView;

@InjectViewState
public class ExitPresenter extends MvpPresenter<ExitView> {

    public void exit(){


        getViewState().performExit();
    }

}
