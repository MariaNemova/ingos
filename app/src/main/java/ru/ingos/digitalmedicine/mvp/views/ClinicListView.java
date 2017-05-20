package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;


public interface ClinicListView extends MvpView {

    void setClinics(List<ClinicListModel> clinics);
    @StateStrategyType(SkipStrategy.class)
    void moveMap(LatLng ll);
    @StateStrategyType(SkipStrategy.class)
    void zoom(float zoom);
    @StateStrategyType(SkipStrategy.class)
    void addMarker(MarkerOptions mo);
}
