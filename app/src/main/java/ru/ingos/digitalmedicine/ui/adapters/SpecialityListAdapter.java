package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.models.SpecialityModel;


public class SpecialityListAdapter extends BaseAdapter {

    private List<SpecialityModel> specialties;
    private LayoutInflater layoutInflater;

    public SpecialityListAdapter(Context context, List<SpecialityModel> specialties) {
        this.specialties = specialties;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return specialties.size();
    }

    @Override
    public Object getItem(int position) {
        notifyDataSetChanged();
        return specialties.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_speciality, parent, false);
        }

        SpecialityModel specialityModel = getSpecialityModel(position);

        TextView tvSpeciality = (TextView) view.findViewById(R.id.tvSpeciality);
        tvSpeciality.setText(specialityModel.getName());



        return view;
    }


    private SpecialityModel getSpecialityModel(int position){
        return (SpecialityModel) getItem(position);
    }
}


