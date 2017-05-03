package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.ui.activities.ClinicInfoActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.activities.NewRegistryActivity;
import ru.ingos.digitalmedicine.ui.adapters.holders.ClinicHolder;
import ru.ingos.digitalmedicine.ui.listeners.ClinicListOnClickListener;
import ru.ingos.digitalmedicine.ui.models.ClinicModel;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Alexandr on 15.04.2017.
 *
 */

public class ClinicListAdapter extends RecyclerView.Adapter<ClinicHolder> {

    private List<ClinicModel> clinics;
    private final ClinicListOnClickListener listener;

    public ClinicListAdapter(List<ClinicModel> data, Activity activity) {
        this.clinics = data;
        if(activity == null){
            throw  new RuntimeException("You must set an actibity for the ClinicsList!");
        }

        boolean isMainActivity = activity instanceof MainActivity;
        if(isMainActivity){
            listener = new ClinicListOnClickListener(activity, ClinicInfoActivity.class);
        }else {
            listener = new ClinicListOnClickListener(activity, NewRegistryActivity.class);
        }
    }

    @Override
    public ClinicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ClinicHolder(view);
    }

    @Override
    public void onBindViewHolder(ClinicHolder holder, int position) {
        String clinicName = clinics.get(position).getNameClinic();
        String cliniAdress = clinics.get(position).getAddresClinic();

        holder.setClinicName(clinicName);
        holder.setClinicAdress(cliniAdress);
        holder.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return clinics.size();
    }




}
