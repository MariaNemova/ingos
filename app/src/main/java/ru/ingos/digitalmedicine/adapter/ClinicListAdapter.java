package ru.ingos.digitalmedicine.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.Clinic;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Alexandr on 15.04.2017.
 */

public class ClinicListAdapter extends RecyclerView.Adapter<ClinicListAdapter.ClinicHolder> {

    private List<Clinic> data;

    public ClinicListAdapter(List<Clinic> data) {
        this.data = data;
    }

    @Override
    public ClinicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ClinicHolder(view);
    }

    @Override
    public void onBindViewHolder(ClinicHolder holder, int position) {
        holder.tvNameClinic.setText(data.get(position).getNameClinic());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ClinicHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tvNameClinic;

        public ClinicHolder(View itemView) {
            super(itemView);

            tvNameClinic = (TextView) itemView.findViewById(R.id.tvNameClinic);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
