package ru.ingos.digitalmedicine.ui.fragments.fragmentmain;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class FavoriteFragment extends MVP4Fragment {

    @BindView(R.id.child_fragment_favorite_rv_clinics)
    RecyclerView rvClinics;
    @BindView(R.id.child_fragment_favorite_rv_doctors)
    RecyclerView rvDoctors;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.child_fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);
    }

}
