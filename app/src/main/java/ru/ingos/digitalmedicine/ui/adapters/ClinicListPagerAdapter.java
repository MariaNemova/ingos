package ru.ingos.digitalmedicine.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentList;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentMap;

import java.util.ArrayList;
import java.util.List;

public class ClinicListPagerAdapter extends FragmentPagerAdapter {

    private List<Mvp4Fragment> mFragments;

    public ClinicListPagerAdapter(FragmentManager fm) {
        super(fm);

        this.mFragments = new ArrayList<>();
        this.mFragments.add(new FragmentList());
        this.mFragments.add(new FragmentMap());
    }

    @Override
    public int getCount() {
        return this.mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(IngosApplication.DEBUG_TAG, "Getting page at position: "+position);
        return this.mFragments.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        boolean isViewFromObject = view == ((Fragment)object).getView();
        Log.d(IngosApplication.DEBUG_TAG, String.valueOf(isViewFromObject));
        return isViewFromObject;
    }

    @Override
    public CharSequence getPageTitle(int pos){
        switch (pos){
            case 0:
                return "Списком";
            case 1:
                return "На карте";
            default:
                return "";
        }
    }
}
