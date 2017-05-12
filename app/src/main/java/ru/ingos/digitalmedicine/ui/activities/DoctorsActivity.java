package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.presenters.DoctorListPresenter;
import ru.ingos.digitalmedicine.mvp.views.DoctorListView;
import ru.ingos.digitalmedicine.ui.adapters.DoctorListAdapter;

public class DoctorsActivity extends MvpAppCompatActivity implements DoctorListView, ListView.OnItemClickListener{

    @BindView(R.id.activity_doctor_list_list_view)
    ListView lvDoctorList;

    @InjectPresenter
    DoctorListPresenter presenter;

    private DoctorListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        ButterKnife.bind(this);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setTitle(R.string.frag_title_doctor);

        mAdapter = new DoctorListAdapter(getApplicationContext());
        lvDoctorList.setAdapter(mAdapter);
        lvDoctorList.setOnItemClickListener(this);

    }

    @Override
    public void setDoctors(List<DoctorModel> doctors) {
        mAdapter.setmDoctors(doctors);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, NewRegistryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
