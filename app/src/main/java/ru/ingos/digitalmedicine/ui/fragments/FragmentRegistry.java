package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.RegistryListAdapter;
import ru.ingos.digitalmedicine.ui.models.RegistryModel;

public class FragmentRegistry extends MvpFragment {

    @BindView(R.id.rvRegistry)
    RecyclerView rvRegistry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_registry, getActivity());
        return inflater.inflate(R.layout.fragment_layout_registry,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        rvRegistry.setLayoutManager(new LinearLayoutManager(null));
        rvRegistry.setAdapter(new RegistryListAdapter(registry(), getActivity()));
    }


    //TODO перевести все на MVP
    private List<RegistryModel> registry (){
        List<RegistryModel> registry = new ArrayList<>();
        registry.add(new RegistryModel("11 мая, 2017 год. 12:00", "ЛОР", "Ул. Пушкина, д. 12, каб. 112"));
        registry.add(new RegistryModel("16 мая, 2017 год. 15:00", "Уролог", "Ул. Красная, д. 25, каб. 302"));
        registry.add(new RegistryModel("1 июня, 2017 год. 11:00", "Окулист", "Ул. Семеновская, д. 31, каб. 202"));

        return registry;
    }

}