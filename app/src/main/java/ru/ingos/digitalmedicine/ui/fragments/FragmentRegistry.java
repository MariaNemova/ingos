package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RegistryModel;
import ru.ingos.digitalmedicine.mvp.presenters.RegistryListPresenter;
import ru.ingos.digitalmedicine.mvp.views.RegistryListView;
import ru.ingos.digitalmedicine.ui.adapters.RegistryListAdapter;

public class FragmentRegistry extends MvpFragment implements RegistryListView {


    @InjectPresenter
    RegistryListPresenter presenter;

    private RegistryListAdapter adapter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View mainView = inflater.inflate(R.layout.fragment_layout_registry, container, false);
        unbinder = ButterKnife.bind(mainView);
        RecyclerView rvRegistry = (RecyclerView) mainView.findViewById(R.id.rvRegistry);
        adapter = new RegistryListAdapter(getActivity());
        if (rvRegistry!=null){
            rvRegistry.setAdapter(adapter);
        }
        presenter.setRegistry();
        Utils.setActivityTitle(R.string.frag_title_registry, getActivity());
        return mainView;
    }

    @Override
    public void setRegistry(List<RegistryModel> registry) {
        adapter.setRegistry(registry);
    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        rvRegistry.setLayoutManager(new LinearLayoutManager(null));
        //rvRegistry.setAdapter(new RegistryListAdapter(registry(), getActivity()));
    }
*/

    //TODO перевести все на MVP


}