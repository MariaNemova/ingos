package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.ui.models.ClinicModel;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран списка, списка клиник врачей и прочего!
 */
public class FragmentList extends FragmentBase {

    private final static int LAYOUT = R.layout.fragment_layout_list;

    public FragmentList(){
        super();
        super.setLayout(LAYOUT);
        super.setTitle(R.string.frag_title_clinics);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);//не забывать вызывать родительский метод
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new ClinicListAdapter(createData()));

        return view;
    }

    private List<ClinicModel> createData() {
        List<ClinicModel> clinics = new ArrayList<>();
        clinics.add(new ClinicModel("ClinicModel 1"));
        clinics.add(new ClinicModel("ClinicModel 2"));
        clinics.add(new ClinicModel("ClinicModel 3"));
        clinics.add(new ClinicModel("ClinicModel 4"));
        clinics.add(new ClinicModel("ClinicModel 5"));
        return clinics;
    }
}
