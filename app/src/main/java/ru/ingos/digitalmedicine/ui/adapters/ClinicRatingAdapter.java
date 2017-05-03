package ru.ingos.digitalmedicine.ui.adapters;

import android.media.Rating;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RatingItemModel;
import ru.ingos.digitalmedicine.ui.adapters.holders.HeaderHolder;
import ru.ingos.digitalmedicine.ui.adapters.holders.RatingHolder;

import java.util.List;
import java.util.zip.Inflater;

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
}
