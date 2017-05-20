package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.presenters.DoctorListPresenter;
import ru.ingos.digitalmedicine.mvp.views.DoctorListView;
import ru.ingos.digitalmedicine.ui.adapters.DoctorListAdapter;

import java.util.List;

public class DoctorsActivity extends MvpAppCompatActivity implements DoctorListView, ListView.OnItemClickListener, ListView.OnItemLongClickListener {

    @BindView(R.id.activity_doctor_list_list_view)
    ListView lvDoctorList;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "DoctorListPresenter")
    DoctorListPresenter presenter;

    private DoctorListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.frag_title_doctor);
        }
        
        mAdapter = new DoctorListAdapter(getApplicationContext());
        lvDoctorList.setAdapter(mAdapter);
        lvDoctorList.setOnItemClickListener(this);
        lvDoctorList.setOnItemLongClickListener(this);
        
        String clinicName = getIntent().getStringExtra(IngosApplication.EXTRA_CLINIC_NAME);
        presenter.loadDoctors(clinicName==null, clinicName);
        presenter.setDoctors();
    }

    @Override
    public void setDoctors(List<DoctorModel> doctors) {
        mAdapter.setmDoctors(doctors);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, NewRegistryActivity.class);
        intent.putExtra(IngosApplication.EXTRA_DOCTOR_ID, 2);
        startActivity(intent);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DoctorProfileActivity.class);
        intent.putExtra(IngosApplication.EXTRA_DOCTOR_ID, 2);
        startActivity(intent);

        return true;
    }
}
