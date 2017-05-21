package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import android.widget.TextView;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.models.ClinicModel;
import ru.ingos.digitalmedicine.ui.activities.ClinicInfoActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.activities.NewRegistryActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Alexandr on 15.04.2017.
 *
 */

public class ClinicListAdapter extends RecyclerView.Adapter<ClinicListAdapter.ClinicHolder> {

    private List<ClinicListModel> mClinics = new ArrayList<>();

    public void setClinics(List<ClinicListModel> mClinics) {
        this.mClinics = mClinics;
    }

    private final OnClickListener mListener;

    public ClinicListAdapter(Activity activity, boolean shouldOpenInformation) {
          if(activity == null){
              throw  new RuntimeException("You must set an activity for the ClinicsList!");
          }

        if(shouldOpenInformation){
            mListener = new OnClickListener(activity, ClinicInfoActivity.class, null);
        }else {
            Log.d(IngosApplication.DEBUG_TAG, "Not main activity!");
            mListener = new OnClickListener(activity, NewRegistryActivity.class, IngosApplication.EXTRA_DOCTOR_ID, -1);
        }
    }

    @Override
    public ClinicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ClinicHolder(view);
    }

    @Override
    public void onBindViewHolder(ClinicHolder holder, int position) {
        String clinicName = mClinics.get(position).getNameClinic();
        String cliniAdress = mClinics.get(position).getAddresClinic();

        holder.setClinicName(clinicName);
        holder.setClinicAdress(cliniAdress);
        mListener.setValue(position);
        holder.setOnClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return mClinics.size();
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
