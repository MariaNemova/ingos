package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.presenters.HomePresenter;
import ru.ingos.digitalmedicine.mvp.views.HomeView;
import ru.ingos.digitalmedicine.ui.activities.ClinicInfoActivity;
import ru.ingos.digitalmedicine.ui.activities.SpecialtyActivity;

public class FragmentMain extends MvpFragment implements HomeView, AdapterView.OnClickListener{

    @BindView(R.id.fragment_main_last_clinic_name) TextView tvClinicName;
    @BindView(R.id.fragment_main_last_clinic_tel) TextView tvClinicPhone;
    @BindView(R.id.fragment_main_last_clinic_adress) TextView tvClinicAdress;
    @BindView(R.id.fragment_main_last_clinic_work_hours) TextView tvClinicWorkHours;
    @BindView(R.id.fragment_main_insuranse_username) TextView tvInsuranceFullname;
    @BindView(R.id.fragment_main_insuranse_expire) TextView tvInsuranceExpire;
    @BindView(R.id.fragment_main_block_insuranse) LinearLayout llBlockInsurance;
    @BindView(R.id.fragment_main_btn_register) RelativeLayout rlAddRegistry;
    @BindView(R.id.fragment_main_last_clinic_info) LinearLayout llClinicInfo;
    @BindView(R.id.fragment_main_btn_registry_list) RelativeLayout rlRegistryList;
    @BindView(R.id.fragment_main_btn_building_list) RelativeLayout rlClinicList;
    @BindView(R.id.fragment_main_block_statistics) LinearLayout llBlockStatistics;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "HomePresenter") HomePresenter homePresenter;

    private Unbinder unbinder;

    public FragmentMain(){
        super();
    }

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Utils.setActivityTitle(R.string.frag_title_main, getActivity());

        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance){
        unbinder = ButterKnife.bind(this, view);
        llBlockInsurance.setOnClickListener(this);
        rlAddRegistry.setOnClickListener(this);
        llClinicInfo.setOnClickListener(this);
        rlRegistryList.setOnClickListener(this);
        rlClinicList.setOnClickListener(this);
        llBlockStatistics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(IngosApplication.DEBUG_TAG, "Click!");

        int id = v.getId();
        switch (id){
            case R.id.fragment_main_block_insuranse:
                homePresenter.onInsuranceInfoClick();
                break;
            case R.id.fragment_main_btn_register:
                homePresenter.onNewRegistryBtnClick();
                break;
            case R.id.fragment_main_block_statistics:
                homePresenter.onStatisticsClick();
                break;
            case R.id.fragment_main_btn_building_list:
                homePresenter.onBuildingListClick();
                break;
            case R.id.fragment_main_last_clinic_info:
                homePresenter.onClinicInfoClick();
                break;
            case R.id.fragment_main_btn_registry_list:
                homePresenter.onRegistryListClick();
                break;
            default:
                break;
        }
    }

    @Override
    public void setLastClinicInfo(String name, String adress, String phone, String workHours) {
        tvClinicName.setText(name);
        tvClinicAdress.setText(adress);
        tvClinicPhone.setText(phone);
        tvClinicWorkHours.setText(workHours);
    }

    @Override
    public void setInsuranceInfo(String userName, String expire, Boolean isRed) {
        tvInsuranceFullname.setText(userName);
        tvInsuranceExpire.setText(expire);

        int red = ContextCompat.getColor(getActivity(), R.color.colorAccent);
        int white = ContextCompat.getColor(getActivity(), R.color.White);

        tvInsuranceExpire.setTextColor(isRed?red:white);
    }

    @Override
    public void showPrivateRoom() {
        Utils.showFragmentInActivity(FragmentPrivateRoom.class, getActivity());
    }

    @Override
    public void showStatistics() {
        Utils.showFragmentInActivity(FragmentHistory.class, getActivity());
    }

    @Override
    public void createNewRegistry()
    {
        startActivity(new Intent(getActivity(), SpecialtyActivity.class));
    }

    @Override
    public void showClinicsList()
    {
        Utils.showFragmentInActivity(FragmentClinicList.class, getActivity());
    }

    @Override
    public void showClinicInfo() {
        Intent clinicInfo = new Intent(getActivity(), ClinicInfoActivity.class);
        startActivity(clinicInfo);
    }

    @Override
    public void showRegistryList() {
        Utils.showFragmentInActivity(FragmentRegistry.class, getActivity());
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    
    
}
