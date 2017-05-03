package ru.ingos.digitalmedicine.ui.fragments.clinicinfo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;
import ru.ingos.digitalmedicine.mvp.presenters.RatingScreenPresenter;
import ru.ingos.digitalmedicine.mvp.views.RatingView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicRatingAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

import java.util.List;

public class FragmentRating extends MVP4Fragment implements RatingView{

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "RatingPresenter")
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
        ratingContainer.setAdapter(new ClinicRatingAdapter());

    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setRatingItems(List<RatingItemModel> arr) {
        Log.d("MOJAR", "Setting rating items. Total size: "+arr.size());
        ((ClinicRatingAdapter)ratingContainer.getAdapter()).setItems(arr);
        ratingContainer.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setRatingTotal(float ratingTotal) {
        Log.d("MOJAR", "Setting rating total: "+ratingTotal);
        ((ClinicRatingAdapter)ratingContainer.getAdapter()).setTotal(ratingTotal);
        ratingContainer.getAdapter().notifyDataSetChanged();
    }
}
