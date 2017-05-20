package ru.ingos.digitalmedicine.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.Service;
import ru.ingos.digitalmedicine.ui.activities.DoctorsActivity;
import ru.ingos.digitalmedicine.ui.fragments.clinicinfo.FragmentServices;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;


public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.ServiceListHolder>{

    private List<Service> services = new ArrayList<>();
    private OnClickListener listener;

    public ServiceListAdapter(Activity activity) {
        listener = new OnClickListener(activity, DoctorsActivity.class, IngosApplication.EXTRA_CLINIC_NAME);
    }

    @Override
    public ServiceListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciality, parent, false);

        return new ServiceListHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceListHolder holder, int position) {
        Service current = this.services.get(position);
        holder.setData(current);
        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return this.services.size();
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public class ServiceListHolder extends RecyclerView.ViewHolder {

        TextView tvSpeciality;

        public ServiceListHolder(View itemView) {
            super(itemView);

            tvSpeciality = (TextView) itemView.findViewById(R.id.item_speciality_text_view_spec);
        }

        public void setData(Service currentObject) {
            this.tvSpeciality.setText(currentObject.getName());
        }

    }
}
