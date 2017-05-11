package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentList;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentMap;

import java.util.ArrayList;
import java.util.List;

public class ClinicListPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments;

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
        return this.mFragments.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
