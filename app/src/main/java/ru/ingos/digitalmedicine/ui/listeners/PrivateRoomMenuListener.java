package ru.ingos.digitalmedicine.ui.listeners;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import ru.ingos.digitalmedicine.IngosApplication;

public class PrivateRoomMenuListener implements View.OnClickListener {

    private final RecyclerView mView;

    public PrivateRoomMenuListener(RecyclerView mView) {
        this.mView = mView;
    }


    @Override
    public void onClick(View v) {
        int pos = this.mView.getChildAdapterPosition(v);

        switch (pos){
            case 0: //Персональыне данные
                Log.d(IngosApplication.DEBUG_TAG, "Personal info click!");
                break;
            case 1: //Информация о страховке
                Log.d(IngosApplication.DEBUG_TAG, "Insurance info click");
                break;
            case 2: //Сервисы
                Log.d(IngosApplication.DEBUG_TAG, "Services click!");
                break;
            case 3: //Статистика
                Log.d(IngosApplication.DEBUG_TAG, "Statistics click!");
                break;
        }
    }
}
