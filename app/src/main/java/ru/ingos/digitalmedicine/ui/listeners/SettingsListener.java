package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SettingsListener implements View.OnClickListener {

    private final RecyclerView rvSettings;
    private final Activity activity;

    public SettingsListener(RecyclerView rvSettings, Activity activity) {
        this.rvSettings = rvSettings;
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        int position = this.rvSettings.getChildAdapterPosition(v);

        switch (position){
            case 0: // Подключить услуги
                break;
            case 1: // Поменять пароль
                break;
            case 2: // Выйти из приложения
                break;
        }

    }
}
