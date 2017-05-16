package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;

public class SosActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_select_registry_btn_spec) Button btnSelectSpec;
    @BindView(R.id.activity_select_registry_btn_doctor) Button btnSelectDoctor;
    @BindView(R.id.activity_select_registry_btn_clinic) Button btnSelectClinic;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_select_registry);

        ButterKnife.bind(this);
        //TODO: также заменить значки
        btnSelectSpec.setText("Позвонить в скорую");
        btnSelectDoctor.setText("Позвонить дежурному врачу");
        btnSelectClinic.setText("Написать дежурному врачу");

        btnSelectSpec.setOnClickListener(this);
        btnSelectDoctor.setOnClickListener(this);
        btnSelectClinic.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle("Срочная помощь");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.activity_select_registry_btn_spec:
                callNumber("112");
                break;
            case R.id.activity_select_registry_btn_doctor:
                callNumber("+79154779946");
                break;
            case R.id.activity_select_registry_btn_clinic:

                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private void callNumber(String number){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        startActivity(intent);
    }
}
