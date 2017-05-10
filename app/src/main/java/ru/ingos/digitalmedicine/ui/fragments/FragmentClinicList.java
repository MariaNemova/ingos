package ru.ingos.digitalmedicine.ui.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import android.widget.TabWidget;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.ui.activities.FragmentHolderActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.models.ClinicModel;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.R;

public class FragmentClinicList extends MvpFragment {

    @BindView(R.id.fragment_clinic_list_tab_host) TabHost tabHost;
    @BindView(R.id.fragment_clinic_list_recycler_view) RecyclerView rvClinicList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);//не забывать вызывать родительский метод
        return inflater.inflate(R.layout.fragment_clinic_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle instance){
        super.onViewCreated(view, instance);
        setActivityTitle();

        ButterKnife.bind(this, view);
        tabHost.setup();
        setupTabs();
        TabWidget widget = tabHost.getTabWidget();
        for(int i = 0; i<widget.getChildCount(); i++){
            ((TextView)widget.getChildAt(i).findViewById(android.R.id.title)).setTextColor(Color.WHITE);
        }

        rvClinicList.setLayoutManager(new LinearLayoutManager(null));
        rvClinicList.setAdapter(new ClinicListAdapter(createData(), getActivity()));

    }

    private void setupTabs(){
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setIndicator(getString(R.string.tab1_text));
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tab2");
        tabSpec.setIndicator(getString(R.string.tab2_text));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);
    }

    //халтура. используй MVP.
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

    private void setActivityTitle(){
        Activity activity = getActivity();
        if(activity instanceof MainActivity){
            ActionBar actionBar = ((MainActivity) activity).getSupportActionBar();
            if(actionBar != null) actionBar.setTitle("Список клиник");
        }else if(activity instanceof FragmentHolderActivity){
            ActionBar actionBar = ((FragmentHolderActivity) activity).getSupportActionBar();
            if(actionBar != null) actionBar.setTitle("Доступные клиники");
        }
    }
}
