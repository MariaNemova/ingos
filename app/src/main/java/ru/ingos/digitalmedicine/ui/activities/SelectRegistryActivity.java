package ru.ingos.digitalmedicine.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentMap;

public class SelectRegistryActivity extends MvpAppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_select_registry_btn_spec) Button btnSelectSpec;
    @BindView(R.id.activity_select_registry_btn_doctor) Button btnSelectDoctor;
    @BindView(R.id.activity_select_registry_btn_clinic) Button btnSelectClinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_registry);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.title_select_activity);
        }
        btnSelectSpec.setOnClickListener(this);
        btnSelectDoctor.setOnClickListener(this);
        btnSelectClinic.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        IngosApplication.SHOW_CLINIC_INFO = false; //FIXME: лютый костыль! все исправить
        switch (v.getId()){
            case R.id.activity_select_registry_btn_spec:
                startActivity(new Intent(this, SpecialtyActivity.class));
                break;
            case R.id.activity_select_registry_btn_doctor:
                Intent intent = new Intent(this, DoctorsActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_select_registry_btn_clinic:
                Utils.showFragmentSupportInActivity(FragmentMap.class, this);
                break;
            default:
                break;
        }
    }
}
