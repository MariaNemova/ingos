package ru.ingos.digitalmedicine.mvp.presenters;

import android.content.SharedPreferences;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.common.Sha256;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.views.AuthView;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView> {

    public void tryAuth(String login, String password){
        if(login.equals("")){
            getViewState().showMessage("Не введен логин");
            return;
        }

        if(password.equals("")){
            getViewState().showMessage("Не введен паоль");
            return;
        }

        Sha256 passFromUser = new Sha256(password);
        Sha256 serverPass = new Sha256("123456");
        if(login.equals("12345678") && passFromUser.equals(serverPass)){
            SharedPreferences.Editor edit = IngosApplication.GLOBAL_PREFERENCES.edit();
            edit.putInt(IngosApplication.PREF_SESSION_ID, Utils.GLOBAL_RANDOM.nextInt(9999999));//id should be bigger
            edit.apply();
            getViewState().successfulAuthorization();
        }else{
            getViewState().showMessage("Не удалось авторизоваться");
        }
    }

}
