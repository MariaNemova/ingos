package ru.ingos.digitalmedicine.ui.fragments.fragment_main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class RegistryFragment extends MVP4Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.child_fragment_registry, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){

    }

}
