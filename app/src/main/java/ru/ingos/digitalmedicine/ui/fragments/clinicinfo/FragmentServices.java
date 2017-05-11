package ru.ingos.digitalmedicine.ui.fragments.clinicinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.Service;
import ru.ingos.digitalmedicine.mvp.presenters.ServiceListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ServiceListView;
import ru.ingos.digitalmedicine.ui.adapters.ServiceListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;

import java.util.List;

public class FragmentServices extends Mvp4Fragment implements ServiceListView{

    @BindView(R.id.clinic_info_services_list)
    ListView services;

    @InjectPresenter
    ServiceListPresenter presenter;

    private ServiceListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.pager_fragment_services, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(view);
        ListView serviceList = (ListView) view.findViewById(R.id.clinic_info_services_list);
        adapter = new ServiceListAdapter(getContext());
        if(serviceList!=null){
            serviceList.setAdapter(adapter);
        }
    }

    @Override
    public void setServices(List<Service> services) {
        adapter.setServices(services);
    }
}
