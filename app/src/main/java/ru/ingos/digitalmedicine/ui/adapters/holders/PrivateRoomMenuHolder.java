package ru.ingos.digitalmedicine.ui.adapters.holders;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import ru.ingos.digitalmedicine.R;

public class PrivateRoomMenuHolder extends RecyclerView.ViewHolder {

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
