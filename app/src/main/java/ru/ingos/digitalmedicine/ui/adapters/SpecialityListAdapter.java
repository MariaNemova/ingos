package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.SpecialityModel;


public class SpecialityListAdapter extends BaseAdapter {

    private List<SpecialityModel> mSpecialties;
    private LayoutInflater layoutInflater;

    public SpecialityListAdapter(Context context) {
        super();

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setSpecialties(List<SpecialityModel> specialties) {
        this.mSpecialties = specialties;
    }

    @Override
    public int getCount() {
        if(mSpecialties == null){
            return 0;
        }
        return mSpecialties.size();
    }

    @Override
    public Object getItem(int position) {
        return mSpecialties.get(position);
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


        TextView tvSpeciality = (TextView) view.findViewById(R.id.item_speciality_text_view_spec);
        tvSpeciality.setText(((SpecialityModel) getItem(position)).getNameSpec());

        return view;
    }
}


