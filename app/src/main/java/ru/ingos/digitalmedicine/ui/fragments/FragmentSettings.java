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
import ru.ingos.digitalmedicine.ui.adapters.SettingsAdapter;


public class FragmentSettings extends MvpFragment {

    @BindView(R.id.fragment_settings_recycler_view)
    RecyclerView rvSettings;

    private SettingsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_settings, getActivity());
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new SettingsAdapter();

        rvSettings.setLayoutManager(new LinearLayoutManager(null));
        rvSettings.setAdapter(mAdapter);

    }
}
