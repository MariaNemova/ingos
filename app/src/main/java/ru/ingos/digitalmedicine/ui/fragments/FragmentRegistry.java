package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RegistryModel;
import ru.ingos.digitalmedicine.mvp.presenters.RegistryListPresenter;
import ru.ingos.digitalmedicine.mvp.views.RegistryListView;
import ru.ingos.digitalmedicine.ui.adapters.RegistryListAdapter;

import java.util.List;

public class FragmentRegistry extends MvpFragment implements RegistryListView {


    @InjectPresenter(type = PresenterType.GLOBAL, tag = "RegistryListPresenter")
    RegistryListPresenter presenter;

    @BindView(R.id.rvRegistry)
    RecyclerView rvRegistry;

    private RegistryListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Utils.setActivityTitle(R.string.frag_title_registry, getActivity());
        return inflater.inflate(R.layout.fragment_registry, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        adapter = new RegistryListAdapter(getActivity());

        rvRegistry.setAdapter(adapter);
        rvRegistry.setLayoutManager(new LinearLayoutManager(null));
    }

    @Override
    public void setRegistry(List<RegistryModel> registry) {
        adapter.setmRegistry(registry);
    }
}