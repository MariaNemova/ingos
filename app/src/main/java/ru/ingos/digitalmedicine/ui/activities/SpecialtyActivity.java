package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.adapters.SpecialityListAdapter;
import ru.ingos.digitalmedicine.ui.models.SpecialityModel;


public class SpecialtyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new SpecialityListAdapter(this, createData()));
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
}
