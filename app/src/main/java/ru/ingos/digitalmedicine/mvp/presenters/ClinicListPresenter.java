package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class ClinicListPresenter extends MvpPresenter<ClinicListView> {
    private List<ClinicListModel> mClinics;

    private final static double minX = 37.369025;
    private final static double maxX = 37.841201;
    private final static double minY = 55.570548;
    private final static double maxY = 55.911777;

    private boolean requested = false;

    private List<ClinicListModel> loadClinics() {
        List<ClinicListModel> clinics = new ArrayList<>();
        clinics.add(new ClinicListModel("Будь здоров", "ул. Пушкина, д. 15"));
        clinics.add(new ClinicListModel("Клиника 2", "ул. Ленина, д. 22"));
        clinics.add(new ClinicListModel("Клиника 3", "ул. Васина, д. 41"));
        clinics.add(new ClinicListModel("Клиника 4", "ул. Петина, д. 67"));
        clinics.add(new ClinicListModel("Клиника 5", "ул. Иванова, д. 23"));
        clinics.add(new ClinicListModel("Клиника 6", "ул. Кек, д. 74"));
        clinics.add(new ClinicListModel("Клиника 7", "ул. Лел, д. 111"));

        return clinics;
    }

    @Override
    public void onFirstViewAttach() {
        Utils.logPresenterCreated(ClinicListPresenter.class);
        this.mClinics = loadClinics();
        if(requested)setClinics();
    }

    public void setClinics(){
        if(this.mClinics == null) requested=true;
        else getViewState().setClinics(new ArrayList<>(mClinics));
    }

    public void setMapInfo(){
        Log.d(IngosApplication.DEBUG_TAG, "ClinicList map info setted!");
        LatLng ll = new LatLng(55.751760, 37.618158);

        getViewState().moveMap(ll);
        getViewState().zoom(10);

        for (int i=0; i<mClinics.size();i++){
            MarkerOptions mo = new MarkerOptions();
            mo.position(rendomPointInSquare());
            getViewState().addMarker(mo);
        }
    }

    private LatLng rendomPointInSquare(){
        double dX = maxX - minX;
        double dY = maxY - minY;

        double randX = minY + Utils.GLOBAL_RANDOM.nextDouble()*dX;
        double randY = minY + Utils.GLOBAL_RANDOM.nextDouble()*dY;

        return new LatLng(randX, randY);
    }

}
