package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;
import ru.ingos.digitalmedicine.ui.listeners.HomeServiceListener;
import ru.ingos.digitalmedicine.ui.listeners.ServicesListener;

public class InsuranceServiceAdapter extends RecyclerView.Adapter<InsuranceServiceAdapter.InsuranceServiceHolder>{

    private List<InsuranceServiceModel> mInsuranceServices;
    private LayoutInflater mInflater;

    private ServicesListener listener;
    private HomeServiceListener homeListener;

    public InsuranceServiceAdapter(Context context, ServicesListener listener, HomeServiceListener homeListener){
        super();

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        this.listener = listener;
        this.homeListener = homeListener;
    }

    public void setmInsuranceServices(List<InsuranceServiceModel> mInsuranceServices) {
        this.mInsuranceServices = mInsuranceServices;
    }

    @Override
    public InsuranceServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciality, parent, false);
        view.setOnClickListener(listener);
        view.setOnClickListener(homeListener);

        return new InsuranceServiceHolder(view);
    }

    @Override
    public void onBindViewHolder(InsuranceServiceHolder holder, int position) {
        InsuranceServiceModel current = mInsuranceServices.get(position);
        holder.setData(current);
    }

    @Override
    public int getItemCount() {
        return mInsuranceServices.size();
    }

    public class InsuranceServiceHolder extends RecyclerView.ViewHolder {

        private TextView mInsuranceName;

        public InsuranceServiceHolder(View itemView) {
            super(itemView);

            mInsuranceName = (TextView) itemView.findViewById(R.id.item_speciality_text_view_spec);
        }

        public void setData(InsuranceServiceModel currentObject){
            this.mInsuranceName.setText(currentObject.getNameService());
        }
    }
}
