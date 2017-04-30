package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.ui.models.ClinicModel;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Alexandr on 15.04.2017.
 *
 */

public class ClinicListAdapter extends RecyclerView.Adapter<ClinicListAdapter.ClinicHolder> {

    private List<ClinicModel> clinics;

    public ClinicListAdapter(List<ClinicModel> data) {
        this.clinics = data;
    }

    @Override
    public ClinicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ClinicHolder(view);
    }

    @Override
    public void onBindViewHolder(ClinicHolder holder, int position) {
        holder.tvNameClinic.setText(clinics.get(position).getNameClinic());
        holder.tvAddresClinic.setText(clinics.get(position).getAddresClinic());
    }

    @Override
    public int getItemCount() {
        return clinics.size();
    }

    static class ClinicHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tvNameClinic;
        TextView tvAddresClinic;

        ClinicHolder(View itemView) {
            super(itemView);

            tvNameClinic = (TextView) itemView.findViewById(R.id.tvNameClinic);
            tvAddresClinic = (TextView) itemView.findViewById(R.id.tvAddresClinic);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
