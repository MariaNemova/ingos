package ru.ingos.digitalmedicine.ui.fragments.clinicinfo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.adapters.ClinicRatingAdapter;
import ru.ingos.digitalmedicine.ui.fragments.base.MVP4Fragment;

public class FragmentRating extends MVP4Fragment{

    @BindView(R.id.clinic_rating)
    RecyclerView ratingContainer;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.pager_fragment_rating, container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        unbinder = ButterKnife.bind(this, view);
        ratingContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        ratingContainer.setAdapter(new ClinicRatingAdapter());
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

}
