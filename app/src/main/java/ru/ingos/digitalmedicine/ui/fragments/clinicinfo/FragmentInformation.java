package ru.ingos.digitalmedicine.ui.fragments.clinicinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.R;



public class FragmentInformation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View mainView = inflater.inflate(R.layout.pager_fragment_clinic_info, container, false);
        return mainView;
    }

}
