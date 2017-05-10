package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.ReceptionModel;
import ru.ingos.digitalmedicine.mvp.views.ReceptionListView;

@InjectViewState
public class ReceptionListPresenter extends MvpPresenter<ReceptionListView> {

    private List<ReceptionModel> mReceptions;

    private List<ReceptionModel> loadReceptions() {
        List<ReceptionModel> receptions = new ArrayList<>();

        receptions.add(new ReceptionModel("Невролог", "5 мая, 2016 год"));
        receptions.add(new ReceptionModel("Терапевт", "10 апреля, 2016 год"));
        receptions.add(new ReceptionModel("ЛОР", "23 марта, 2016 год"));
        receptions.add(new ReceptionModel("Терапевт", "11 января, 2016 год"));

        return receptions;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(ReceptionListPresenter.class);
        this.mReceptions = loadReceptions();
        setReceptions();
    }

    private void setReceptions() {
        getViewState().setReceptions(new ArrayList<>(mReceptions));
    }
}
