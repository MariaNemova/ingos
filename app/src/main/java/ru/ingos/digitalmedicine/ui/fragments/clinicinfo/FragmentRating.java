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
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;
import ru.ingos.digitalmedicine.mvp.presenters.RatingScreenPresenter;
import ru.ingos.digitalmedicine.mvp.views.RatingView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicRatingAdapter;
import ru.ingos.digitalmedicine.ui.fragments.base.MVP4Fragment;

import java.util.List;

public class FragmentRating extends MVP4Fragment implements RatingView{

    @InjectPresenter
    RatingScreenPresenter presenter;

    @BindView(R.id.clinic_rating)
    RecyclerView ratingContainer;

    private Unbinder unbinder;
    private ClinicRatingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.pager_fragment_rating, container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        unbinder = ButterKnife.bind(this, view);
        ratingContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        this.adapter = new ClinicRatingAdapter();
        ratingContainer.setAdapter(adapter);

        presenter.onScreenLoading();
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setRatingItems(List<RatingItemModel> arr) {
        this.adapter.setItems(arr);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void setRatingTotal(float ratingTotal) {
        this.adapter.setTotal(ratingTotal);
        this.adapter.notifyDataSetChanged();
    }
}
