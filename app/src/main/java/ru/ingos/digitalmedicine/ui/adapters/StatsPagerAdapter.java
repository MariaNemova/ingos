package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.ui.fragments.stats.DoctorsStats;
import ru.ingos.digitalmedicine.ui.fragments.stats.GlobalStats;
import ru.ingos.digitalmedicine.ui.fragments.stats.RecipeStats;
import ru.ingos.digitalmedicine.ui.layouts.CustomPager;

public class StatsPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> statsFragments;
    private final int mPosition = -1;

    public StatsPagerAdapter(FragmentManager fm) {
        super(fm);

        this.statsFragments = new ArrayList<>();
        this.statsFragments.add(new GlobalStats());
        this.statsFragments.add(new DoctorsStats());
        this.statsFragments.add(new RecipeStats());
    }

    @Override
    public Fragment getItem(int position) {
        return statsFragments.get(position);
    }

    @Override
    public int getCount() {
        return statsFragments.size();
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
                return "Общая статистика";
            case 1:
                return "Статистика по врачам";
            case 2:
                return "Статистика по рецептам";
            default:
                return null;
        }
    }
}
