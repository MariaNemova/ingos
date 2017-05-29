package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorModel;

public class DoctorListAdapter extends BaseAdapter{

    private List <DoctorModel> doctors;
    private LayoutInflater layoutInflater;

    public DoctorListAdapter(Context context) {
        super();

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDoctors(List<DoctorModel> doctors) {
        this.doctors = doctors;
    }

    @Override
    public int getCount() {
        if(doctors == null){
            return 0;
        }
        return doctors.size();
    }

    @Override
    public Object getItem(int position) {
        return doctors.get(position);
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

        TextView tvDocName = (TextView) view.findViewById(R.id.item_speciality_text_view_spec);
        tvDocName.setText(((DoctorModel) getItem(position)).getNameDoctor());

        return view;
    }
}
