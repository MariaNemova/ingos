package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.InsuranceInfoModel;
import ru.ingos.digitalmedicine.mvp.views.InsuranceInfoView;

@InjectViewState
public class InsuranceInfoPresenter extends MvpPresenter<InsuranceInfoView> {

    private InsuranceInfoModel insuranceInfo;

    private void loadInsuranceInfo(){
        insuranceInfo = new InsuranceInfoModel("Леонид Каприов",
                "0000 0000 0000",
                "365 дней");

    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(InsuranceInfoPresenter.class);
        setInsuranceInfo();
    }

    private void setInsuranceInfo() {
        loadInsuranceInfo();
        getViewState().setInsuranceInfo(
                insuranceInfo.getName(),
                insuranceInfo.getInsuranceNumber(),
                insuranceInfo.getInsuranceDate()
        );
    }
}
