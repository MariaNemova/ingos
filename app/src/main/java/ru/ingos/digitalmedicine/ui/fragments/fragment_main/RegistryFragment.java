package ru.ingos.digitalmedicine.ui.fragments.fragment_main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RegistryModel;
import ru.ingos.digitalmedicine.mvp.presenters.RegistryListPresenter;
import ru.ingos.digitalmedicine.mvp.views.RegistryListView;
import ru.ingos.digitalmedicine.ui.activities.SelectRegistryActivity;
import ru.ingos.digitalmedicine.ui.adapters.RegistryListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.FragmentMain;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

import java.util.List;

public class RegistryFragment extends MVP4Fragment implements RegistryListView, View.OnClickListener{

    @BindView(R.id.child_fragment_registry_recyclerview) RecyclerView rvRegistryList;
    @BindView(R.id.child_fragment_registry_btn) Button newRegistryBtn;

    private RegistryListAdapter adapter;

    @InjectPresenter RegistryListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.child_fragment_registry, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);
        adapter = new RegistryListAdapter(getActivity());
        rvRegistryList.setAdapter(adapter);
        rvRegistryList.setLayoutManager(new LinearLayoutManager(getContext()));
        newRegistryBtn.setOnClickListener(this);
    }

    @Override
    public void setRegistry(List<RegistryModel> registry) {
        adapter.setmRegistry(registry);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.child_fragment_registry_btn:
                Intent intent = new Intent(getActivity(), SelectRegistryActivity.class);
                startActivity(intent);
        }
    }
}
