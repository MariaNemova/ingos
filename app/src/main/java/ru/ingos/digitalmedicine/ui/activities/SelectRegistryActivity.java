package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.adapters.SelectRegistryAdapter;

public class SelectRegistryActivity extends MvpAppCompatActivity {

    @BindView(R.id.activity_select_registry_recycler_view)
    RecyclerView rvSelectRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_registry);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.title_select_activity);

        ButterKnife.bind(this);

        rvSelectRegistry.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSelectRegistry.setAdapter(new SelectRegistryAdapter());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
