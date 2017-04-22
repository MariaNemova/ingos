package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.R;

public class ClinicInfoActivity extends MvpAppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    @BindView(R.id.clinic_info_toolbar)
    Toolbar toolbar;

    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_clicnic_info);

        unbinder = ButterKnife.bind(this);

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.clinic_info_map);
        map.getMapAsync(this);

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");
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
}
