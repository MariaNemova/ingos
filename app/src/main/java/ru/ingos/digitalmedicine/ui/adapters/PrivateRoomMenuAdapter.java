package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.PrivateRoomMenuItem;
import ru.ingos.digitalmedicine.ui.adapters.holders.PrivateRoomMenuHolder;

import java.util.ArrayList;
import java.util.List;

public class PrivateRoomMenuAdapter extends RecyclerView.Adapter<PrivateRoomMenuHolder> {

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
}
