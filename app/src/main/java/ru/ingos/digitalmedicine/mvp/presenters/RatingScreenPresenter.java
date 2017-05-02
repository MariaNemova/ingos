package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.viewstate.MvpViewState;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;
import ru.ingos.digitalmedicine.mvp.views.RatingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiya on 02.05.2017.
 */
@InjectViewState
public class RatingScreenPresenter extends MvpPresenter<RatingView> {

    private List<RatingItemModel> items = new ArrayList<>();
    private float totalRating;

    private boolean loading = false;
    private boolean requested = false;

    @Override
    public void onFirstViewAttach(){
        //здесь должна происходить настоящая загрузка с диска. но ее нет покачто.
        Log.d("MOJAR", "Загружаю рейтинг откуда-то");
        //симулмрую асинхронность
        this.loading = true;
        loadAllRatingItems();
        this.loading = false;
        if(requested){
            setScreen();
        }
    }

    public void onScreenLoading(){
        if(loading){
            this.requested = true;
            return;
        }
        setScreen();
    }

    private void setScreen(){
        getViewState().setRatingItems(new ArrayList<RatingItemModel>(items));//рву ссылку воизбежание утечек памяти
        getViewState().setRatingTotal(this.totalRating);
        this.requested = false;//асинхронный доступ сюда?
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
