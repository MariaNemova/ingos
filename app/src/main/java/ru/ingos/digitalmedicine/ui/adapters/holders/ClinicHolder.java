package ru.ingos.digitalmedicine.ui.adapters.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;

public class ClinicHolder extends RecyclerView.ViewHolder{


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
