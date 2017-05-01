package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.ui.fragments.clinicinfo.FragmentInformation;
import ru.ingos.digitalmedicine.ui.fragments.clinicinfo.FragmentRating;
import ru.ingos.digitalmedicine.ui.fragments.clinicinfo.FragmentServices;
import ru.ingos.digitalmedicine.ui.layouts.CustomPager;

import java.util.ArrayList;
import java.util.List;

public class ClinicInfoPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private int mCurrentPosition = -1;


    public ClinicInfoPagerAdapter(FragmentManager fm){
        super(fm);
        this.fragments = new ArrayList<>();

        this.fragments.add(new FragmentInformation());
        this.fragments.add(new FragmentServices());
        this.fragments.add(new FragmentRating());
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object){
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            if(fragment.getView()!=null){
                ((CustomPager) container).measureCurrentView(fragment.getView());
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
