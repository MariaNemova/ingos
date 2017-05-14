package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.SettingsModel;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsHolder>{

    private List<SettingsModel> settings = new ArrayList<>();

    public SettingsAdapter() {
        settings.add(new SettingsModel("Подключить услуги"));
        settings.add(new SettingsModel("Изменить пароль"));
        settings.add(new SettingsModel("Выйти"));
    }

    @Override
    public SettingsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciality, parent, false);

        return new SettingsHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsHolder holder, int position) {
        SettingsModel current = this.settings.get(position);
        holder.setData(current);
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }

    public class  SettingsHolder extends RecyclerView.ViewHolder {

        TextView tvSetting;

        public SettingsHolder(View itemView) {
            super(itemView);

            tvSetting = (TextView) itemView.findViewById(R.id.item_speciality_text_view_spec);
        }

        void setData(SettingsModel currentObject){
            this.tvSetting.setText(currentObject.getNameSetting());
        }
    }
}
