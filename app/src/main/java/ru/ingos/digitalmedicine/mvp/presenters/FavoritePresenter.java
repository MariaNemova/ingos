package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.mvp.views.FavoriteView;

@InjectViewState
public class FavoritePresenter  extends MvpPresenter<FavoriteView>{

    @Override
    public void onFirstViewAttach(){
        setFavoriteClinics();
        setFavoriteDoctors();
    }

    public void setFavoriteClinics(){

    }

    public void setFavoriteDoctors(){

    }

}
