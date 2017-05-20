package ru.ingos.digitalmedicine.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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
        //return this.mFragments.size();
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(IngosApplication.DEBUG_TAG, "Getting page at position: "+position);
        //return this.mFragments.get(position);
        try {
            return FragmentList.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
