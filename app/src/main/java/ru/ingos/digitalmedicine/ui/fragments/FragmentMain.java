package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.mvp.presenters.HomePresenter;
import ru.ingos.digitalmedicine.mvp.views.HomeView;
import ru.ingos.digitalmedicine.ui.activities.SpecialtyActivity;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Фрагмент, представляющий собой главный экран приложения. На нем располагаются ключевые кнопки, информация о
 * состоянии страховки и последняя активная запись к врачу.
 */
public class FragmentMain extends FragmentBase implements HomeView, AdapterView.OnClickListener{

    @BindView(R.id.last_clinic_name)
    TextView clinicName;
    @BindView(R.id.last_clinic_tel)
    TextView clinicPhone;
    @BindView(R.id.last_clinic_adress)
    TextView clinicAdress;
    @BindView(R.id.last_clinic_work_hours)
    TextView clinicWorkHours;

    @BindView(R.id.insuranse_username)
    TextView insuranceFullname;
    @BindView(R.id.insuranse_expire)
    TextView insuranceExpire;

    @InjectPresenter
    HomePresenter homePresenter;

    private static int[] BLOCKS = {
            R.id.block_insuranse
    };

    public FragmentMain(){
        super();
        super.setLayout(R.layout.fragment_layout_main);
        super.setTitle(R.string.frag_title_main);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse){
        View temp = super.onCreateView(inflater,container,savedInstanse);

        for (int id:BLOCKS){
            LinearLayout ll = (LinearLayout) this.globalView.findViewById(id);
            ll.setOnClickListener(this);
        }

        RelativeLayout main_btn  = (RelativeLayout) this.globalView.findViewById(R.id.btn_register);
        main_btn.setOnClickListener(this);

        ButterKnife.bind(this,temp);
        return temp;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.block_insuranse:
                homePresenter.onInsuranceInfoClick();
                break;
            case R.id.btn_register:
                homePresenter.onNewRegistryBtnClick();
                break;
            case R.id.block_statistics:
                homePresenter.onStatisticsClick();
                break;
            default:
                break;
        }
    }

    @Override
    public void setLastClinicInfo(String name, String adress, String phone, String workHours) {
        clinicName.setText(name);
        clinicAdress.setText(adress);
        clinicPhone.setText(phone);
        clinicWorkHours.setText(workHours);
    }

    @Override
    public void setInsuranceInfo(String userName, String expire, Boolean isRed) {
        insuranceFullname.setText(userName);
        insuranceExpire.setText(expire);
        insuranceExpire.setTextColor(isRed?R.color.colorAccent:R.color.White);
    }

    @Override
    public void showPrivateRoom() {
        super.changeView(FragmentPrivateRoom.class);
    }

    @Override
    public void showStatistics() {
        //TODO: добавить переход на экран статистики
    }

    @Override
    public void createNewRegistry() {
        startActivity(new Intent(getActivity(), SpecialtyActivity.class));
    }
}
