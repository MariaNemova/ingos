package ru.ingos.digitalmedicine.ui.activities;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.ingos.digitalmedicine.R;

public class AuthActivity extends MvpAppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_auth);
    }

}
