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

public class DoctorListAdapter extends BaseAdapter {

    private List<DoctorModel> mDoctors;
    private LayoutInflater layoutInflater;

    public DoctorListAdapter(Context context) {
        super();

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setmDoctors(List<DoctorModel> mDoctors) {
        this.mDoctors = mDoctors;
    }

    @Override
    public int getCount() {
        if (mDoctors == null){
            return 0;
        }
        return mDoctors.size();
    }

    @Override
    public Object getItem(int position) {
        return mDoctors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_doctor, parent, false);
        }

        TextView tvDoctor = (TextView) view.findViewById(R.id.item_doctor_text_view_doctor);
        tvDoctor.setText(((DoctorModel) getItem(position)).getNameDoctor());

        return view;
    }


}
