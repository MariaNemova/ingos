package ru.ingos.digitalmedicine.ui.fragments.stats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorStatsModel;
import ru.ingos.digitalmedicine.mvp.presenters.DoctorStatsPresenter;
import ru.ingos.digitalmedicine.mvp.views.DoctorStatsView;
import ru.ingos.digitalmedicine.ui.adapters.DoctorStatsAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class DoctorsStats extends MVP4Fragment implements DoctorStatsView {

    @BindView(R.id.pager_fragment_doctor_stats_recycler_view)
    RecyclerView rvDoctorStats;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "DoctorStatsPresenter")
    DoctorStatsPresenter presenter;

    private DoctorStatsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_fragment_doctor_stats, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        mAdapter = new DoctorStatsAdapter(getActivity());

        rvDoctorStats.setLayoutManager(new LinearLayoutManager(null));
        rvDoctorStats.setAdapter(mAdapter);


    }

    @Override
    public void setDoctorStats(List<DoctorStatsModel> doctorStats) {
        mAdapter.setDoctorStats(doctorStats);
    }
}
