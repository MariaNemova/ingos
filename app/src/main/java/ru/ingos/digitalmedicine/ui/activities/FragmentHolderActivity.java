package ru.ingos.digitalmedicine.ui.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;

import static java.lang.Class.forName;

public class FragmentHolderActivity extends MvpAppCompatActivity{


//    @BindView(R.id.fragment_holder)
//    FrameLayout container;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fragment_holder);

//        ButterKnife.bind(this);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setupFragment();
    }

    private void setupFragment(){
        String className = getIntent().getStringExtra(IngosApplication.EXTRA_CLASSNAME_NAME);
        try {
            Class fragmentClass = Class.forName(className);
            Object fragmentInstance = fragmentClass.newInstance();
            bindFragment(fragmentInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void bindFragment(Object fragment){
        if(Fragment.class.isAssignableFrom(fragment.getClass())){
            Fragment frag = (Fragment) fragment;
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.fragment_holder, frag);
            trans.commit();
        }else{
            Log.d("MOJAR", "Fragment has wrong class! Class: "+fragment.getClass());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
