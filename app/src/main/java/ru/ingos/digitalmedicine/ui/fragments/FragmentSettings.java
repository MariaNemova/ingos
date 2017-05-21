package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
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
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.presenters.ExitPresenter;
import ru.ingos.digitalmedicine.mvp.views.ExitView;
import ru.ingos.digitalmedicine.ui.activities.AuthActivity;
import ru.ingos.digitalmedicine.ui.adapters.SettingsAdapter;
import ru.ingos.digitalmedicine.ui.listeners.SettingsListener;


public class FragmentSettings extends MvpFragment implements ExitView {

    @BindView(R.id.fragment_settings_recycler_view)
    RecyclerView rvSettings;

    @InjectPresenter
    ExitPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_settings, getActivity());
        if (this instanceof FragmentSettings)
            Utils.setActivityIcon(0, getActivity());
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        rvSettings.setLayoutManager(new LinearLayoutManager(null));
        rvSettings.setAdapter(new SettingsAdapter(new SettingsListener(rvSettings, getActivity(),presenter)));

    }


    @Override
    public void performExit() {
        Intent intent = new Intent(getActivity(), AuthActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        getActivity().finish();
    }
}
