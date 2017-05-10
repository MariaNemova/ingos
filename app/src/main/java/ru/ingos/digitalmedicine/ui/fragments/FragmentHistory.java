package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.ReceptionModel;
import ru.ingos.digitalmedicine.mvp.presenters.ReceptionListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ReceptionListView;
import ru.ingos.digitalmedicine.ui.adapters.ReceptionListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentHistory extends MvpFragment implements ReceptionListView{

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "ReceptionListPresenter")
    ReceptionListPresenter presenter;

    private ReceptionListAdapter mAdapter;

    @BindView(R.id.fragment_history_recycler_view) RecyclerView rvMedHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Utils.setActivityTitle(R.string.frag_title_history, getActivity());
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new ReceptionListAdapter(getActivity());

        rvMedHistory.setAdapter(mAdapter);
        rvMedHistory.setLayoutManager(new LinearLayoutManager(null));

    }


    @Override
    public void setReceptions(List<ReceptionModel> receptions) {
        mAdapter.setReceptions(receptions);
    }
}
