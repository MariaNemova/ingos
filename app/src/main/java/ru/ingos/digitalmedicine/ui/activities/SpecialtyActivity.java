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
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.adapters.SpecialityListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.FragmentClinicList;
import ru.ingos.digitalmedicine.ui.models.SpecialityModel;


public class SpecialtyActivity extends MvpAppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.activity_speciality_list_view)
    ListView lvSpecialityList;
//    @BindView(R.id.specListToolbar)
//    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        ButterKnife.bind(this);

//        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setTitle("Выберите специалиста");

        lvSpecialityList.setAdapter(new SpecialityListAdapter(this, createData()));
        lvSpecialityList.setOnItemClickListener(this);
    }

    private List<SpecialityModel> createData(){
        List<SpecialityModel> specialties = new ArrayList<>();

        specialties.add(new SpecialityModel("Терапевт"));
        specialties.add(new SpecialityModel("Ортопед"));
        specialties.add(new SpecialityModel("Гематолог"));
        specialties.add(new SpecialityModel("Логопед"));
        specialties.add(new SpecialityModel("ЛОР"));
        specialties.add(new SpecialityModel("Онколог"));
        specialties.add(new SpecialityModel("Хирург"));

        return specialties;
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
