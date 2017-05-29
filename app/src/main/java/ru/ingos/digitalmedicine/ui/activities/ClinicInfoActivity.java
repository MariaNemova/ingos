package ru.ingos.digitalmedicine.ui.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
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
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.ClinicInfoPagerAdapter;
import ru.ingos.digitalmedicine.ui.listeners.CoordinatorOffsetListener;

public class ClinicInfoActivity extends MvpAppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    @BindView(R.id.clinic_info_toolbar) Toolbar toolbar;
    @BindView(R.id.clinic_info_pager) ViewPager pager;
    @BindView(R.id.clinic_info_app_bar) AppBarLayout appBar;
    @BindView(R.id.activity_clinic_info_fab)
    FloatingActionButton fabFavorite;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_clicnic_info);

        ButterKnife.bind(this);
        pager.setAdapter(new ClinicInfoPagerAdapter(getSupportFragmentManager()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = Utils.getStatusBarHeight(getResources());
            toolbar.setPadding(0, statusBarHeight,0,5);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setSupportActionBar(this.toolbar);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        appBar.addOnOffsetChangedListener(new CoordinatorOffsetListener(this, getSupportActionBar(),toolbar));
        fabFavorite.setOnClickListener(this);
    }

    @Override
    public void onStart(){
        super.onStart();
        setupMap();
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
    public boolean onOptionsItemSelected(MenuItem item){
        //TODO: написать корректный перехват клика именно по кнопке назад
        onBackPressed();
        return true;
    }


    private void setupMap(){
        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.clinic_info_map);
        map.getMapAsync(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
    }
}
