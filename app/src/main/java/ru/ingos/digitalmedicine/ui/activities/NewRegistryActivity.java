package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.ingos.digitalmedicine.R;

public class NewRegistryActivity extends MvpAppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.debug_text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

}
