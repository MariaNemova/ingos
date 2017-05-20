package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.presenters.DoctorListPresenter;
import ru.ingos.digitalmedicine.mvp.presenters.DoctorProfilePresenter;
import ru.ingos.digitalmedicine.mvp.views.DoctorListView;
import ru.ingos.digitalmedicine.mvp.views.DoctorProfileView;


public class DoctorProfileActivity extends MvpAppCompatActivity implements DoctorProfileView{


    @BindView(R.id.activity_doctor_profile_doc_name) TextView tvDocName;
    @BindView(R.id.activity_doctor_profile_doc_speciality) TextView tvDocSpeciality;
    @BindView(R.id.activity_doctor_profile_doc_age) TextView tvDocAge;
    @BindView(R.id.activity_doctor_profile_doc_education) TextView tvDocEducation;
    @BindView(R.id.activity_doctor_profile_doc_experience) TextView tvDocExperience;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "DoctorProfilePresenter")
    DoctorProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.title_doctor_profile);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }


    @Override
    public void setDoctorProfile(String docName, String docSpeciality, String docAge, String docEducation, String docExperience) {
        tvDocName.setText(docName);
        tvDocSpeciality.setText(docSpeciality);
        tvDocAge.setText(docAge);
        tvDocEducation.setText(docEducation);
        tvDocExperience.setText(docExperience);
    }
}
