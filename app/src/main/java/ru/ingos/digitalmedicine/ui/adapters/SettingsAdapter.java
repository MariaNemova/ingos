package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.SettingsModel;
import ru.ingos.digitalmedicine.ui.listeners.SettingsListener;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsHolder>{

    private List<SettingsModel> settings = new ArrayList<>();

    private final SettingsListener listener;

    public SettingsAdapter(SettingsListener listener) {
        this.listener = listener;
        settings.add(new SettingsModel("Подключить услуги", R.drawable.ic_link));
        settings.add(new SettingsModel("Изменить пароль", R.drawable.ic_password));
        settings.add(new SettingsModel("Выйти", R.drawable.ic_exit));
    }

    @Override
    public SettingsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_icon, parent, false);
        view.setOnClickListener(listener);

        return new SettingsHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsHolder holder, int position) {
        SettingsModel current = this.settings.get(position);
        holder.setData(current.getNameSetting(), current.getIcon());
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }

    public class  SettingsHolder extends RecyclerView.ViewHolder {

        TextView tvSetting;
        TextView tvDescription;
        AppCompatImageView apivIcon;

        public SettingsHolder(View itemView) {
            super(itemView);

            tvSetting = (TextView) itemView.findViewById(R.id.iconed_list_item_name);
            tvSetting.setTextSize(22);
            tvDescription = (TextView) itemView.findViewById(R.id.iconed_list_item_description);
            tvDescription.setText(null);
            apivIcon = (AppCompatImageView) itemView.findViewById(R.id.iconed_list_item_icon);
        }

        void setData(String nameSetting, int icon){
            this.tvSetting.setText(nameSetting);
            this.apivIcon.setImageResource(icon);
        }
    }
}
