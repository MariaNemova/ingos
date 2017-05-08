package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.PrivateRoomMenuItem;

import java.util.ArrayList;
import java.util.List;

public class PrivateRoomMenuAdapter extends RecyclerView.Adapter<PrivateRoomMenuAdapter.PrivateRoomMenuHolder> {

    List<PrivateRoomMenuItem> items = new ArrayList<>();

    public  PrivateRoomMenuAdapter(){
        items.add(new PrivateRoomMenuItem("Персональные данные", "Изменение ваших данных и пароля", R.drawable.ic_profile));
        items.add(new PrivateRoomMenuItem("Информация о страховке", "Доступные услуги, сроки окончания", R.drawable.ic_info));
        items.add(new PrivateRoomMenuItem("Сервисы", "Изменить программу, продлить полис", R.drawable.ic_service));
        items.add(new PrivateRoomMenuItem("Статистика", "Инормация о посещенных клиниках", R.drawable.ic_stats));
    }

    @Override
    public PrivateRoomMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_icon, parent, false);
        return new PrivateRoomMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(PrivateRoomMenuHolder holder, int position) {
        PrivateRoomMenuItem cur = this.items.get(position);
        holder.setNameTV(cur.getItemName());
        holder.setDescriptionTV(cur.getItemDescription());
        holder.setIcon(cur.getItemIconPointer());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public static class PrivateRoomMenuHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;
        private AppCompatImageView icon;

        public PrivateRoomMenuHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.iconed_list_item_name);
            description = (TextView) itemView.findViewById(R.id.iconed_list_item_description);
            icon = (AppCompatImageView) itemView.findViewById(R.id.iconed_list_item_icon);

            if(name == null || description == null || icon == null)
                throw  new RuntimeException("Wrong view in the PrivateRoomMenuHolder. Can't find children!");

        }

        public void setNameTV (String name){
            this.name.setText(name);
        }

        public void setDescriptionTV(String description){
            this.description.setText(description);
        }

        public void setIcon(int iconPointer){
            this.icon.setImageResource(iconPointer);
        }

    }
}
