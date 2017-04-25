package ru.ingos.digitalmedicine.ui.fragments.clinicinfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.Service;
import ru.ingos.digitalmedicine.mvp.presenters.ServiceListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ServiceListView;
import ru.ingos.digitalmedicine.ui.adapters.ServiceListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.base.MVP4Fragment;
import ru.ingos.digitalmedicine.ui.layouts.CustomPager;

import java.util.List;

public class FragmentServices extends MVP4Fragment implements ServiceListView{

    @BindView(R.id.clinic_info_services_list)
    ListView services;

    @InjectPresenter
    ServiceListPresenter presenter;

    private ServiceListAdapter adapter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View mainView = inflater.inflate(R.layout.pager_fragment_services, container, false);
        unbinder = ButterKnife.bind(mainView);
        ListView serviceList = (ListView) mainView.findViewById(R.id.clinic_info_services_list);
        adapter = new ServiceListAdapter(getContext());
        if(serviceList!=null){
            Log.d("MOJAR", "Адаптер установлен!");
            serviceList.setAdapter(adapter);
        }
        presenter.setServices();

//        mesureContainerAgain(container,mainView);
        return mainView;
    }

    private void mesureContainerAgain(ViewGroup container, View view){
        if(!(container instanceof CustomPager)) return;

        CustomPager pager = (CustomPager) container;
        pager.measureCurrentView(view);
        int mesureWidth = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int mesureHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        pager.measure(mesureWidth, mesureHeight);
        Log.d("MOJAR", "New height: "+pager.getMeasuredHeight());
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setServices(List<Service> services) {
        adapter.setServices(services);
    }
}