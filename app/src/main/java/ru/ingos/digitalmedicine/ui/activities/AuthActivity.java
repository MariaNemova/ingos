package ru.ingos.digitalmedicine.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.AuthPresenter;
import ru.ingos.digitalmedicine.mvp.views.AuthView;

public class AuthActivity extends MvpAppCompatActivity implements AuthView, View.OnClickListener{

    @BindView(R.id.activity_auth_btn) Button authBtn;
    @BindView(R.id.activity_auth_login) TextView login;
    @BindView(R.id.activity_auth_pass) TextView pass;
    @InjectPresenter AuthPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);
        authBtn.setOnClickListener(this);
    }

    @Override
    public void successfulAuthorization() {
        Intent intent = new Intent(this, CreatePinActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.activity_auth_btn:
                presenter.tryAuth(login.getText().toString(), pass.getText().toString());
        }
    }
}
