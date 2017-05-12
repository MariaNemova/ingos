package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.SpecialityModel;
import ru.ingos.digitalmedicine.mvp.presenters.SpecialityListPresenter;
import ru.ingos.digitalmedicine.mvp.views.SpecialityListView;
import ru.ingos.digitalmedicine.ui.adapters.SpecialityListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.FragmentClinicList;


public class SpecialtyActivity extends MvpAppCompatActivity implements AdapterView.OnItemClickListener, SpecialityListView {

    @BindView(R.id.activity_speciality_list_view)
    ListView lvSpecialityList;
//    @BindView(R.id.specListToolbar)
//    Toolbar toolbar;

    @InjectPresenter
    SpecialityListPresenter presenter;

    private SpecialityListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        ButterKnife.bind(this);

//        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setTitle(R.string.frag_title_spec);

        mAdapter = new SpecialityListAdapter(getApplicationContext());
        lvSpecialityList.setAdapter(mAdapter);
        lvSpecialityList.setOnItemClickListener(this);

    }

    @Override
    public void setSpecialties(List<SpecialityModel> specialties) {
        mAdapter.setSpecialties(specialties);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, FragmentHolderActivity.class);
        intent.putExtra(IngosApplication.EXTRA_FRAGMENT_CLASSNAME, FragmentClinicList.class.getName());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
