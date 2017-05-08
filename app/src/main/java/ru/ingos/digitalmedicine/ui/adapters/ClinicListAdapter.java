package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import android.widget.TextView;
import ru.ingos.digitalmedicine.ui.activities.ClinicInfoActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.activities.NewRegistryActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;
import ru.ingos.digitalmedicine.ui.models.ClinicModel;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Alexandr on 15.04.2017.
 *
 */

public class ClinicListAdapter extends RecyclerView.Adapter<ClinicListAdapter.ClinicHolder> {

    private List<ClinicModel> clinics;
    private final OnClickListener listener;

    public ClinicListAdapter(List<ClinicModel> data, Activity activity) {
        this.clinics = data;
        if(activity == null){
            throw  new RuntimeException("You must set an actibity for the ClinicsList!");
        }

        boolean isMainActivity = activity instanceof MainActivity;
        if(isMainActivity){
            listener = new OnClickListener(activity, ClinicInfoActivity.class);
        }else {
            listener = new OnClickListener(activity, NewRegistryActivity.class);
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


    public static class ClinicHolder extends RecyclerView.ViewHolder{


        private TextView tvNameClinic;
        private TextView tvAddresClinic;
        private View view;

        public ClinicHolder(View itemView) {
            super(itemView);

            tvNameClinic = (TextView) itemView.findViewById(R.id.tvNameClinic);
            tvAddresClinic = (TextView) itemView.findViewById(R.id.tvAddresClinic);
            this.view = itemView;
        }

        public void setClinicName(String name) {
            this.tvNameClinic.setText(name);
        }

        public void setClinicAdress(String address) {
            this.tvAddresClinic.setText(address);
        }

        public void setOnClickListener(View.OnClickListener listener){
            view.setOnClickListener(listener);
        }

    }
}
