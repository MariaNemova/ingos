package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.SpecialityModel;
import ru.ingos.digitalmedicine.mvp.presenters.SpecialityListPresenter;
import ru.ingos.digitalmedicine.mvp.views.SpecialityListView;
import ru.ingos.digitalmedicine.ui.adapters.SpecialityListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.FragmentClinicList;

import java.util.List;


public class SpecialtyActivity extends MvpAppCompatActivity implements AdapterView.OnItemClickListener, SpecialityListView {

    @BindView(R.id.activity_speciality_list_view) ListView lvSpecialityList;
    
    @InjectPresenter
    SpecialityListPresenter presenter;

    private SpecialityListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.frag_title_spec);
        }

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
        Utils.showFragmentSupportInActivity(FragmentClinicList.class, this, id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
