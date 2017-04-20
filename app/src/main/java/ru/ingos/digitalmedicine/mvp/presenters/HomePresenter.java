package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.ClinicModel;
import ru.ingos.digitalmedicine.mvp.models.InsuranceModel;
import ru.ingos.digitalmedicine.mvp.views.HomeView;

import java.util.concurrent.TimeUnit;

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {

    private ClinicModel lastClinic;
    private InsuranceModel insuranceInfo;

    private void loadClinicInfo(){
        //На самом деле здесь должна происходить некоторая загрузка с диска. Но она пока не реализована.
        lastClinic = new ClinicModel(
                "Тестовая Клиника",
                "+7(915)477-99-46",
                "Пн-Пт: 9:00-18:00",
                "Москва",
                "Тестовая",
                23,
                3);
    }

    private void loadInsuranceInfo(){
        //На самом деле здесь должна происходить некоторая загрузка с диска. Но она пока не реализована.
        insuranceInfo = new InsuranceModel(
                "Андрей",
                "Ворницкий",
                Utils.getDate(2017, 05, 15)
        );
    }

    private void showInsuranceInfo(){
        loadInsuranceInfo();

        long days_between = TimeUnit.DAYS.convert(
                insuranceInfo.getExpireDate().getTime()-System.currentTimeMillis(),
                TimeUnit.MILLISECONDS);

        getViewState().setInsuranceInfo(
                insuranceInfo.getUserName()+" "+insuranceInfo.getUserSurname(),
                String.valueOf(days_between),
                days_between<30);
    }

    private void showClinicInfo(){
        loadClinicInfo();

        Log.d("[DEBUG]", getViewState().toString());

        getViewState().setLastClinicInfo(
                lastClinic.getClinicName(),
                lastClinic.getClinincAdress(),
                lastClinic.getClinicPhone(),
                lastClinic.getClinicWorkHours()
        );
    }

    @Override
    public void onFirstViewAttach(){
        showClinicInfo();
        showInsuranceInfo();
    }

    public void onInsuranceInfoClick(){
        getViewState().showPrivateRoom();
    }

    public void onStatisticsClick(){
        getViewState().showStatistics();
    }

    public void onNewRegistryBtnClick(){
        getViewState().createNewRegistry();
    }

}
