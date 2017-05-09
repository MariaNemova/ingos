package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.viewstate.MvpViewState;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;
import ru.ingos.digitalmedicine.mvp.views.RatingView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class RatingScreenPresenter extends MvpPresenter<RatingView> {

    private List<RatingItemModel> items = new ArrayList<>();
    private float totalRating;

    @Override
    public void onFirstViewAttach(){
        Utils.logPresenterCreated(this.getClass());
        loadAllRatingItems();
        setScreen();
    }

    private void setScreen(){
        getViewState().setRatingItems(new ArrayList<RatingItemModel>(items));//рву ссылку воизбежание утечек памяти
        getViewState().setRatingTotal(this.totalRating);
    }

    private void loadAllRatingItems(){
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));
        items.add(new RatingItemModel("Иванов Иван", 3.5f, "Здесь какой-либо текст. Комментарий от самого этого пользоавтеля"));

        this.calculateTotalRating();
    }

    private void calculateTotalRating(){
        float total = 0f;
        for(RatingItemModel model:items){
            total+=model.getRating();
        }

        total/=(float)items.size();
        this.totalRating = total;
    }

}
