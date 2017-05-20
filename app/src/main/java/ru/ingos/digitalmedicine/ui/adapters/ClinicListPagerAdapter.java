package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import ru.ingos.digitalmedicine.common.CanPutIdExtra;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentList;
import ru.ingos.digitalmedicine.ui.fragments.cliniclist.FragmentMap;

import java.util.ArrayList;
import java.util.List;

public class ClinicListPagerAdapter extends FragmentStatePagerAdapter {

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
        boolean isViewFromObject = view == ((Fragment)object).getView() || object == view;
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

    public void setId(long id){
        for(Fragment frag:mFragments)
            if (frag instanceof CanPutIdExtra){
                ((CanPutIdExtra) frag).putId(id);
            }
    }
}
