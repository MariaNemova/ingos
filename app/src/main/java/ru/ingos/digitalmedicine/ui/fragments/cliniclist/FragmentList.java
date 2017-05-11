package ru.ingos.digitalmedicine.ui.fragments.cliniclist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.presenters.ClinicListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;

import java.util.List;

public class FragmentList extends Mvp4Fragment implements ClinicListView {

    private ClinicListAdapter mClinicListAdapter;

    @InjectPresenter(type=PresenterType.GLOBAL, tag="ClinicListPresenter") ClinicListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return new RecyclerView(getActivity());
    }

    public void onViewCreated(View view, Bundle savedInstance){
        RecyclerView mainView = (RecyclerView) view;
        mClinicListAdapter = new ClinicListAdapter(getActivity());
        mainView.setLayoutManager(new LinearLayoutManager(getContext()));
        mainView.setAdapter(mClinicListAdapter);

        presenter.setClinics();
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics)
    {
        mClinicListAdapter.setClinics(clinics);
    }

    @Override
    public void moveMap(LatLng ll) {    }

    @Override
    public void zoom(float zoom) {    }

    @Override
    public void addMarker(MarkerOptions mo) {    }
}
