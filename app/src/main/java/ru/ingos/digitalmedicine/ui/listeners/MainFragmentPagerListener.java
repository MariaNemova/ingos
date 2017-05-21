package ru.ingos.digitalmedicine.ui.listeners;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import ru.ingos.digitalmedicine.IngosApplication;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentPagerListener implements ViewPager.OnPageChangeListener {

    private List<String> titles = new ArrayList<>();
    private ActionBar actionBar;

    public MainFragmentPagerListener(ActionBar actionBar){
        this.titles.add("Мои записи");
        this.titles.add("Мой страховой полис");
        this.titles.add("Избранное");

        this.actionBar = actionBar;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(actionBar != null) actionBar.setTitle(titles.get(position));
        else Log.w(IngosApplication.DEBUG_TAG, "Can't find action bar! in: "+getClass().getSimpleName());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
