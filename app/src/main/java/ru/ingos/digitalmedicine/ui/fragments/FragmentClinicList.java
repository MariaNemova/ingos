package ru.ingos.digitalmedicine.ui.fragments;

import android.app.Activity;
import android.content.ContentProvider;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.presenters.ClinicListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;
import ru.ingos.digitalmedicine.ui.activities.FragmentHolderActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.R;

public class FragmentClinicList extends MvpFragment implements ClinicListView {

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "ClinicListPresenter")
    ClinicListPresenter presenter;

    @BindView(R.id.fragment_clinic_list_tab_host)
    TabHost tabHost;

    @BindView(R.id.fragment_clinic_list_recycler_view)
    RecyclerView rvClinicList;

    private ClinicListAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);
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

        mAdapter = new ClinicListAdapter(getActivity());

        rvClinicList.setAdapter(mAdapter);
        rvClinicList.setLayoutManager(new LinearLayoutManager(null));

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


    private void setActivityTitle(){
        Activity activity = getActivity();
        if(activity instanceof MainActivity){
            ((MainActivity) activity).getSupportActionBar().setTitle("Список клиник");
        }else if(activity instanceof FragmentHolderActivity){
            ((FragmentHolderActivity) activity).getSupportActionBar().setTitle("Доступные клиники");
        }
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics) {
        mAdapter.setmClinics(clinics);
    }
}
