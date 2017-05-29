package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.fragments.FragmentClinicList;
import ru.ingos.digitalmedicine.ui.fragments.fragmentmain.InsuranceInfoFragment;
import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentAvailableService;
import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentUnavailableService;

import static android.R.attr.id;

public class ServicesListener implements View.OnClickListener {

    private final Activity activity;
    private final Fragment fragment;

    public ServicesListener(Activity activity, Fragment fragment) {
        this.activity = activity;
        this.fragment = fragment;

    }

    @Override
    public void onClick(View v) {

        if (fragment instanceof InsuranceInfoFragment){
            Utils.showFragmentSupportInActivity(FragmentClinicList.class, activity, id);
        } else if ((fragment instanceof FragmentAvailableService) || (fragment instanceof FragmentUnavailableService)){
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
}
