package ru.ingos.digitalmedicine.ui.fragments.cliniclist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.presenters.ClinicListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;

import java.util.List;

public class FragmentList extends Mvp4Fragment implements ClinicListView {

    private ClinicListAdapter mClinicListAdapter;

    @InjectPresenter(type=PresenterType.GLOBAL, tag="ClinicListPresenter") ClinicListPresenter presenter;

    @BindView(R.id.activty_fragment_holder_holder) FrameLayout flHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.activity_fragment_holder, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);

        RecyclerView mainView = new RecyclerView(getContext());
        mClinicListAdapter = new ClinicListAdapter(getActivity());
        mainView.setLayoutManager(new LinearLayoutManager(getContext()));
        mainView.setAdapter(mClinicListAdapter);

        flHolder.addView(mainView);

        presenter.setClinics();
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics)
    {
        if(mClinicListAdapter != null) mClinicListAdapter.setClinics(clinics);
        else Log.w(IngosApplication.DEBUG_TAG, "ListAdapter in clinic list is null!");
    }

    @Override
    public void moveMap(LatLng ll) {    }

    @Override
    public void zoom(float zoom) {    }

    @Override
    public void addMarker(MarkerOptions mo) {    }
}
