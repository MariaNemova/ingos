package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentAvailableService;
import ru.ingos.digitalmedicine.ui.fragments.insuranceinfo.FragmentUnavailableService;
import ru.ingos.digitalmedicine.ui.layouts.CustomPager;

public class InsuranceServicesInfoPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private final int mPosition = -1;

    public InsuranceServicesInfoPagerAdapter(FragmentManager fm) {
        super(fm);

        this.fragments = new ArrayList<>();
        this.fragments.add(new FragmentAvailableService());
        this.fragments.add(new FragmentUnavailableService());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mPosition) {
            Fragment fragment = (Fragment) object;
            if(fragment.getView()!=null){
                ((CustomPager) container).measureCurrentView(fragment.getView());
            }
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Подключенные услуги";
            case 1:
                return "Не подключенные услуги";
            default:
                return null;
        }
    }
}
