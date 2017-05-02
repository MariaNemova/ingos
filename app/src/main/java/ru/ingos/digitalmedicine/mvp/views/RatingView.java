package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;

import java.util.List;

/**
 * Created by shiya on 02.05.2017.
 */
public interface RatingView extends MvpView {

    public void setRatingItems(List<RatingItemModel> arr);
    public void setRatingTotal(float ratingTotal);

}
