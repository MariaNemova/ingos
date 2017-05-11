package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;

@StateStrategyType(SkipStrategy.class)
public interface ClinicListView extends MvpView {

    void setClinics(List<ClinicListModel> clinics);
    void moveMap(LatLng ll);
    void zoom(float zoom);
    void addMarker(MarkerOptions mo);
}
