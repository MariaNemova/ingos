package ru.ingos.digitalmedicine.ui.fragments.fragmentmain;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;
import ru.ingos.digitalmedicine.mvp.presenters.InsuranceInfoPresenter;
import ru.ingos.digitalmedicine.mvp.presenters.InsuranceServicesPresenter;
import ru.ingos.digitalmedicine.mvp.views.InsuranceInfoView;
import ru.ingos.digitalmedicine.mvp.views.InsuranceServicesView;
import ru.ingos.digitalmedicine.ui.adapters.InsuranceServiceAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;
import ru.ingos.digitalmedicine.ui.listeners.HomeServiceListener;

import static android.R.attr.type;

public class InsuranceInfoFragment  extends MVP4Fragment implements InsuranceServicesView, InsuranceInfoView{

    @BindView(R.id.child_fragment_insurance_name)
    TextView tvName;
    @BindView(R.id.child_fragment_insurance_name_number)
    TextView tvInsuranceNumber;
    @BindView(R.id.child_fragment_insurance_date)
    TextView tvDateInsurance;
    @BindView(R.id.child_fragment_insurance_recycler_view)
    RecyclerView rvAvailableServices;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "InsuranceInfoPresenter")
    InsuranceInfoPresenter presenter;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "InsuranceServicePresenter")
    InsuranceServicesPresenter servicesPresenter;


    private InsuranceServiceAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child_fragment_insurance, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);

        mAdapter = new InsuranceServiceAdapter(getContext(), null, new HomeServiceListener(getActivity()));

        rvAvailableServices.setLayoutManager(new LinearLayoutManager(null));
        rvAvailableServices.setAdapter(mAdapter);
    }

    @Override
    public void setInsuranceServices(List<InsuranceServiceModel> insuranceServices) {
        mAdapter.setmInsuranceServices(insuranceServices);
    }

    @Override
    public void setClosedInsuranceServices(List<InsuranceServiceModel> closedInsuranceServices) {
        return;
    }

    @Override
    public void setInsuranceInfo(String name, String insuranceNumber, String insuranceDate) {
        tvName.setText(name);
        tvInsuranceNumber.setText(insuranceNumber);
        tvDateInsurance.setText(insuranceDate);
    }
}
