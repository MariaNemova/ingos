package ru.ingos.digitalmedicine.ui.fragments.fragmentmain;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;
import ru.ingos.digitalmedicine.mvp.views.FavoriteView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.ui.adapters.EmptyListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

import java.util.List;

public class FavoriteFragment extends MVP4Fragment  implements FavoriteView{

    @BindView(R.id.child_fragment_favorite_rv_clinics)
    RecyclerView rvClinics;
    @BindView(R.id.child_fragment_favorite_rv_doctors)
    RecyclerView rvDoctors;

    ClinicListAdapter adapterClinics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.child_fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);

        rvClinics.setAdapter(new EmptyListAdapter("У вас нет избранных клиник", "Перейти к списку клиник>"));
        rvDoctors.setAdapter(new EmptyListAdapter("У вас нет избранных специалистов", "Перейти к списку специалистов>"));

        rvClinics.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDoctors.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics) {
        adapterClinics = new ClinicListAdapter(getActivity());
        adapterClinics.setClinics(clinics);
        rvClinics.setAdapter(adapterClinics);
    }

    @Override
    public void setDoctors(List<DoctorModel> doctors) {

    }
}
