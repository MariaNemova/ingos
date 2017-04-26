package ru.ingos.digitalmedicine.ui.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.ClinicInfoPagerAdapter;

public class ClinicInfoActivity extends MvpAppCompatActivity implements OnMapReadyCallback, View.OnClickListener, AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.clinic_info_toolbar)
    Toolbar toolbar;
    @BindView(R.id.clinic_info_pager)
    ViewPager pager;
    @BindView(R.id.clinic_info_app_bar)
    AppBarLayout appBar;

    private Unbinder unbinder;
    private int statusBarHeight;
    private boolean collapsed = false;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_clicnic_info);

        unbinder = ButterKnife.bind(this);
        pager.setAdapter(new ClinicInfoPagerAdapter(getSupportFragmentManager()));

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.clinic_info_map);
        map.getMapAsync(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            statusBarHeight = Utils.getStatusBarHeight(getResources());
            toolbar.setPadding(0, statusBarHeight,0,5);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        appBar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onDestroy(){
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng ll = new LatLng(55.654343f, 37.765829f);
        MarkerOptions mo = new MarkerOptions();
        mo.position(ll);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        googleMap.addMarker(mo);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //В силу особенностей этого блока, нельзя ддобавить меню опций на экран

        onBackPressed();
        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
            if(!collapsed){
                showActionBar(getSupportActionBar());
                collapsed = true;
            }
        }else {
            if(collapsed){
                hideActionBar(getSupportActionBar());
                collapsed = false;
            }
        }
    }

    private void showActionBar(ActionBar ab){
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    private void hideActionBar(ActionBar ab){
        toolbar.setBackgroundColor(Color.TRANSPARENT);
    }
}
