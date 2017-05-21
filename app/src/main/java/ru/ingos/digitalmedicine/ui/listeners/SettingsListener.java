package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.presenters.ExitPresenter;
import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentUnavailableService;

public class SettingsListener implements View.OnClickListener {

    private final RecyclerView rvSettings;
    private final Activity activity;
    private final ExitPresenter presenter;

    public SettingsListener(RecyclerView rvSettings, Activity activity, ExitPresenter presenter) {
        this.rvSettings = rvSettings;
        this.activity = activity;
        this.presenter = presenter;
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
                presenter.exit();
                break;
        }

    }
}
