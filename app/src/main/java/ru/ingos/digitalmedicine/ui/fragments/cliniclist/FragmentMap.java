package ru.ingos.digitalmedicine.ui.fragments.cliniclist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.presenters.ClinicListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

import java.util.List;

public class FragmentMap extends MVP4Fragment implements OnMapReadyCallback, ClinicListView{

    @InjectPresenter(type = PresenterType.GLOBAL, tag="ClinicListPresenter") ClinicListPresenter presenter;

    private GoogleMap mClinicsMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return new FrameLayout(getActivity());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        FrameLayout fl = (FrameLayout) view;
        fl.setId(0x23031997);
        SupportMapFragment map = SupportMapFragment.newInstance();
        getChildFragmentManager().beginTransaction().replace(fl.getId(), map).commit();
        map.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mClinicsMap = googleMap;
        presenter.setMapInfo();
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics) {
        //nothing
    }

    @Override
    public void moveMap(LatLng ll) {
        if(this.mClinicsMap != null){
            this.mClinicsMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        }else{
            Log.w(IngosApplication.DEBUG_TAG, "Map in ClinicList is null!");
        }
    }

    @Override
    public void zoom(float zoom) {
        if(this.mClinicsMap != null){
            this.mClinicsMap.moveCamera(CameraUpdateFactory.zoomBy(zoom));
        }else{
            Log.w(IngosApplication.DEBUG_TAG, "Map in ClinicList is null!");
        }
    }

    @Override
    public void addMarker(MarkerOptions mo) {
        if(this.mClinicsMap != null){
            this.mClinicsMap.addMarker(mo);
        }else{
            Log.w(IngosApplication.DEBUG_TAG, "Map in ClinicList is null!");
        }
    }
}
