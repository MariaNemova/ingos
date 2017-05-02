package ru.ingos.digitalmedicine.ui.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import ru.ingos.digitalmedicine.R;

/**
 * Created by shiya on 02.05.2017.
 */
public class HeaderHolder extends RecyclerView.ViewHolder {

    private RatingBar total_rating;

    public HeaderHolder(View itemView) {
        super(itemView);
        total_rating = (RatingBar) itemView.findViewById(R.id.clinic_total_rating);
    }

    public void setTotalRating(float rating){
        this.total_rating.setRating(rating);
    }
}
