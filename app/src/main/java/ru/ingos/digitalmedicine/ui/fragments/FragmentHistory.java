package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.ReceptionListAdapter;
import ru.ingos.digitalmedicine.ui.models.ReceptionModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentHistory extends MvpFragment {

    @BindView(R.id.fragment_history_recyler) RecyclerView rvMedHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Utils.setActivityTitle(R.string.frag_title_history, getActivity());
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        rvMedHistory.setLayoutManager(new LinearLayoutManager(null));
        rvMedHistory.setAdapter(new ReceptionListAdapter(createData(), getActivity()));
    }

    private List<ReceptionModel> createData() {
        List<ReceptionModel> receptions = new ArrayList<>();

        receptions.add(new ReceptionModel("Невролог", "5 мая, 2016 год"));
        receptions.add(new ReceptionModel("Терапевт", "10 апреля, 2016 год"));
        receptions.add(new ReceptionModel("ЛОР", "23 марта, 2016 год"));
        receptions.add(new ReceptionModel("Терапевт", "11 января, 2016 год"));

        return receptions;
    }
}
