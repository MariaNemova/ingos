package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import ru.ingos.digitalmedicine.R;

public class ServicesListener implements View.OnClickListener {

    private final Activity activity;

    public ServicesListener(Activity activity) {
        this.activity = activity;

    }

    @Override
    public void onClick(View v) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity)
                .content(R.string.builder_content)
                .positiveText(R.string.builder_yes)
                .negativeText(R.string.builder_no)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
                        Toast.makeText(activity, "Услуга подключена/отключена!", Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
                        Toast.makeText(activity, "Вы отказались!", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();
    }
}
