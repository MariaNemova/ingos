package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.view.View;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.fragments.FragmentClinicList;

import static android.R.attr.id;

public class HomeServiceListener implements View.OnClickListener {

    private final Activity activity;

    public HomeServiceListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Utils.showFragmentSupportInActivity(FragmentClinicList.class, activity, id);
    }
}
