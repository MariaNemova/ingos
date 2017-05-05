package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.activities.MedCardActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;
import ru.ingos.digitalmedicine.ui.models.ReceptionModel;

public class ReceptionListAdapter extends RecyclerView.Adapter<ReceptionListAdapter.ReceptionHolder> {

    List<ReceptionModel> receptions;
    private final OnClickListener listener;


    public ReceptionListAdapter(List<ReceptionModel> receptions, Activity activity) {
        this.receptions = receptions;
        listener = new OnClickListener(activity, MedCardActivity.class);
    }

    @Override
    public ReceptionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);

        return new ReceptionHolder(view);
    }

    @Override
    public void onBindViewHolder(ReceptionHolder holder, int position) {
        ReceptionModel current = receptions.get(position);
        holder.setData(current);

        holder.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return receptions.size();
    }

    public class ReceptionHolder extends RecyclerView.ViewHolder {

        private TextView tvSpecDoctor;
        private TextView tvDate;
        private View view;

        public ReceptionHolder(View itemView) {
            super(itemView);

            tvSpecDoctor = (TextView) itemView.findViewById(R.id.tvSpecDoctor);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.view = itemView;
        }

        public void setData(ReceptionModel currentObject){
            this.tvSpecDoctor.setText(currentObject.getDocSpec());
            this.tvDate.setText(currentObject.getReceptionDate());
        }

        public void setOnClickListener(View.OnClickListener listener){
            view.setOnClickListener(listener);
        }

    }

}
