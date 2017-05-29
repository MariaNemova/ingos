package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ReceptionModel;
import ru.ingos.digitalmedicine.ui.activities.MedCardActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;

public class ReceptionListAdapter extends RecyclerView.Adapter<ReceptionListAdapter.ReceptionHolder> {

    private List<ReceptionModel> receptions;

    public void setReceptions(List<ReceptionModel> receptions) {
        this.receptions = receptions;
    }

    private final OnClickListener listener;


    public ReceptionListAdapter(Activity activity) {
        listener = new OnClickListener(activity, MedCardActivity.class, null);
    }

    @Override
    public ReceptionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        params.setMargins(0,0,0,3);

        view.setLayoutParams(params);
        return new ReceptionHolder(view);
    }

    @Override
    public void onBindViewHolder(ReceptionHolder holder, int position) {
        ReceptionModel current = receptions.get(position);
        holder.setData(current);
        holder.itemView.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return receptions.size();
    }

    class ReceptionHolder extends RecyclerView.ViewHolder {

        private TextView tvSpecDoctor;
        private TextView tvDate;

        ReceptionHolder(View itemView) {
            super(itemView);

            tvSpecDoctor = (TextView) itemView.findViewById(R.id.item_list_name);
            tvDate = (TextView) itemView.findViewById(R.id.item_list_description);
        }

        void setData(ReceptionModel currentObject){
            this.tvSpecDoctor.setText(currentObject.getDocSpec());
            this.tvDate.setText(currentObject.getReceptionDate());
        }
    }

}
