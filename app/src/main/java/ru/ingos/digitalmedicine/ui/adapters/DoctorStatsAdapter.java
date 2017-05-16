package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.DoctorStatsModel;

public class DoctorStatsAdapter extends RecyclerView.Adapter<DoctorStatsAdapter.DoctorStatsHolder>{

    private List<DoctorStatsModel> doctorStats;
    private LayoutInflater mInflater;

    public DoctorStatsAdapter(Context context) {
        super();

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
    }

    public void setDoctorStats(List<DoctorStatsModel> doctorStats) {
        this.doctorStats = doctorStats;
    }

    @Override
    public DoctorStatsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new DoctorStatsHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctorStatsHolder holder, int position) {
        DoctorStatsModel current = doctorStats.get(position);
        holder.setData(current);
    }

    @Override
    public int getItemCount() {
        return doctorStats.size();
    }

    public class DoctorStatsHolder extends RecyclerView.ViewHolder {

        private TextView tvDoctorName;
        private TextView tvDoctorStats;

        public DoctorStatsHolder(View itemView) {
            super(itemView);

            tvDoctorName = (TextView) itemView.findViewById(R.id.tvNameClinic);
            tvDoctorStats = (TextView) itemView.findViewById(R.id.tvAddresClinic);
        }

        public void setData(DoctorStatsModel currentObject){
            this.tvDoctorName.setText(currentObject.getNameDoctor());
            this.tvDoctorStats.setText(currentObject.getStatsDoctor());
        }
    }
}
