package ru.ingos.digitalmedicine.ui.adapters;


import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RegistryModel;
import ru.ingos.digitalmedicine.ui.activities.RegistryInfoActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;

public class RegistryListAdapter extends RecyclerView.Adapter<RegistryListAdapter.RegistryHolder> {

    private List<RegistryModel> mRegistry;
    private final OnClickListener mListener;

    public RegistryListAdapter(Activity activity) {
        this.mListener = new OnClickListener(activity, RegistryInfoActivity.class);
    }

    @Override
    public RegistryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block_registry_info, parent, false);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)view.getLayoutParams();
        params.setMargins(0,0,0,3);
        view.setBackgroundColor(Color.WHITE);
        view.setLayoutParams(params);

        return new RegistryHolder(view);
    }

    @Override
    public void onBindViewHolder(RegistryHolder holder, int position) {
        RegistryModel current = mRegistry.get(position);
        holder.setData(current);
        holder.setOnClickListener(mListener);

    }

    @Override
    public int getItemCount() {
        return mRegistry !=null? mRegistry.size():0;
    }


    public void setmRegistry(List<RegistryModel> mRegistry) {
        this.mRegistry = mRegistry;
    }

    class RegistryHolder extends RecyclerView.ViewHolder {

        private TextView tvTimeRegistry;
        private TextView tvNameService;
        private TextView tvAddressClinic;

        private View view;


        RegistryHolder(View itemView) {
            super(itemView);

            tvTimeRegistry = (TextView) itemView.findViewById(R.id.tvTimeRegistry);
            tvNameService = (TextView) itemView.findViewById(R.id.tvNameService);
            tvAddressClinic = (TextView) itemView.findViewById(R.id.tvAdClinic);

        }

        void setData(RegistryModel currentObject) {
            this.tvTimeRegistry.setText(currentObject.getTimeRegistry());
            this.tvNameService.setText(currentObject.getNameService());
            this.tvAddressClinic.setText(currentObject.getAddressClinic());
            this.view = itemView;
        }

        void setOnClickListener(View.OnClickListener listener){
            view.setOnClickListener(listener);
        }

    }
}
