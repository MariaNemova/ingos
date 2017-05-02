package ru.ingos.digitalmedicine.ui.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;

public class RatingHolder extends RecyclerView.ViewHolder {

    private TextView fullText;
    private TextView date;
    private RatingBar rating;
    private TextView fullName;

    public RatingHolder(View itemView) {
        super(itemView);

        fullText = (TextView) itemView.findViewById(R.id.rating_client_text);
        date = (TextView) itemView.findViewById(R.id.rating_client_date);
        rating = (RatingBar) itemView.findViewById(R.id.rating_client_rating);
        fullName = (TextView) itemView.findViewById(R.id.rating_client_name);
    }

    public void setItem(String name, String date, String fullText, float rating){
        if(this.fullText != null)
            this.fullText.setText(fullText);
        if(this.fullName != null)
            this.fullName.setText(name);
        if(this.rating != null)
            this.rating.setRating(rating);
        if(this.fullName != null)
            this.fullName.setText(name);
    }
}
