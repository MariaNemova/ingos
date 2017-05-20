package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.ui.fragments.FragmentMain;
import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentUnavailableService;

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
                Utils.showFragmentSupportInActivity(FragmentUnavailableService.class, activity);
                break;
            case 1: // Поменять пароль
                new MaterialDialog.Builder(activity)
                    .title(R.string.input_new_password)
                    .inputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    .input("password", "", new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(MaterialDialog dialog, CharSequence input) {
                            Toast.makeText(activity, "Пароль успешно изменен", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                break;
            case 2: // Выйти из приложения
                //нужнь предварительно удалить все аднные пользователя и сделать так, чтобы никто ничего не узнал.
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra(IngosApplication.EXTRA_IS_FROM_BRGINING, true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                break;
        }

    }
}
