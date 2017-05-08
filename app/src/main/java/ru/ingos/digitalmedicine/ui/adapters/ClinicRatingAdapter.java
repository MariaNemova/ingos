package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;

import java.util.List;

public class ClinicRatingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    final static int TYPE_HEADER = 0;
    final static int TYPE_ITEM = 1;

    private List<RatingItemModel> items;
    private float total;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View tempView;

        switch (viewType){
            case TYPE_HEADER:
                tempView = inflater.inflate(R.layout.pager_rating_header, parent,false);
                return new HeaderHolder(tempView);
            default:
                tempView = inflater.inflate(R.layout.pager_rating_item, parent,false);
                return new RatingHolder(tempView);
        }
    }

    @Override
    public int getItemViewType(int position){
        switch (position){
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RatingHolder){
            RatingHolder tempHolder = (RatingHolder) holder;
            RatingItemModel item = items.get(position-1);
            tempHolder.setItem(item.getAuthor_name(), item.getDate(), item.getFull_text(), item.getRating());
        }else if(holder instanceof HeaderHolder){
            HeaderHolder tempHolder = (HeaderHolder) holder;
            tempHolder.setTotalRating(this.total);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<RatingItemModel> items) {
        this.items = items;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public static class RatingHolder extends RecyclerView.ViewHolder {

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

    public static class HeaderHolder extends RecyclerView.ViewHolder {

        private RatingBar total_rating;

        public HeaderHolder(View itemView) {
            super(itemView);
            total_rating = (RatingBar) itemView.findViewById(R.id.clinic_total_rating);
        }

        public void setTotalRating(float rating){
            this.total_rating.setRating(rating);
        }
    }
}
