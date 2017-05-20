package ru.ingos.digitalmedicine.ui.listeners;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import ru.ingos.digitalmedicine.R;

public class CoordinatorOffsetListener implements AppBarLayout.OnOffsetChangedListener {

    private boolean mCollapsed = false;

    private AppCompatActivity mActivity;
    private ActionBar mActionBar;
    private Toolbar mToolbar;

    public CoordinatorOffsetListener(AppCompatActivity activity, ActionBar mActionBar, Toolbar mToolbar) {
        this.mActivity = activity;
        this.mActionBar = mActionBar;
        this.mToolbar = mToolbar;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
            if(!mCollapsed){
                showActionBar();
                mCollapsed = true;
            }
        }else {
            if(mCollapsed){
                hideActionBar();
                mCollapsed = false;
            }
        }
    }

    private void showActionBar(){
        mToolbar.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.colorPrimary));
    }

    private void hideActionBar(){
        mToolbar.setBackgroundColor(Color.TRANSPARENT);
    }

}
