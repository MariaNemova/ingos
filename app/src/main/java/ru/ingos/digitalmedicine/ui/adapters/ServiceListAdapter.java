package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.Service;
import java.util.List;


public class ServiceListAdapter extends BaseAdapter {

    private List<Service> mServices;

    private LayoutInflater inflater;

    public ServiceListAdapter(Context context){
        super();

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setServices(List<Service> services){
        this.mServices = services;
    }

    @Override
    public int getCount() {
        if(mServices == null){
            return 0;
        }
        return mServices.size();
    }

    @Override
    public Object getItem(int position) {
        return mServices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mServices.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = inflater.inflate(R.layout.item_speciality, parent, false);
        }else {
            view = convertView;
        }
        TextView tvService = (TextView) view.findViewById(R.id.item_speciality_text_view_spec);
        tvService.setText(((Service) getItem(position)).getName());
        return view;
    }
}
