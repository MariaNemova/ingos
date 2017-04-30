package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

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
public class FragmentClinicList extends FragmentBase {

    private final static int LAYOUT = R.layout.fragment_layout_list;

    public FragmentClinicList(){
        super();
        super.setLayout(LAYOUT);
        super.setTitle(R.string.frag_title_clinics);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);//не забывать вызывать родительский метод
        view = inflater.inflate(LAYOUT, container, false);

        TabHost tabHost = (TabHost) view.findViewById(R.id.tab_host);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setIndicator(getString(R.string.tab1_text));
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tab2");
        tabSpec.setIndicator(getString(R.string.tab2_text));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        recyclerView.setAdapter(new ClinicListAdapter(createData()));

        return view;
    }

    private List<ClinicModel> createData() {
        List<ClinicModel> clinics = new ArrayList<>();
        clinics.add(new ClinicModel("Будь здоров", "ул. Пушкина, д. 15"));
        clinics.add(new ClinicModel("Клиника 2", "ул. Ленина, д. 22"));
        clinics.add(new ClinicModel("Клиника 3", "ул. Васина, д. 41"));
        clinics.add(new ClinicModel("Клиника 4", "ул. Петина, д. 67"));
        clinics.add(new ClinicModel("Клиника 5", "ул. Иванова, д. 23"));
        clinics.add(new ClinicModel("Клиника 6", "ул. Кек, д. 74"));
        clinics.add(new ClinicModel("Клиника 7", "ул. Лел, д. 111"));
        return clinics;
    }
}
