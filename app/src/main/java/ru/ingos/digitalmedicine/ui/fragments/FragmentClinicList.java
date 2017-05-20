package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListPagerAdapter;

public class FragmentClinicList extends Fragment {

    @BindView(R.id.fragment_clinic_list_view_pager) ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);
        return inflater.inflate(R.layout.fragment_clinic_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle instance){
        setActivityTitle();

        ButterKnife.bind(this, view);
        pager.setAdapter(new ClinicListPagerAdapter(getChildFragmentManager()));
    }

    private void setActivityTitle(){
        Utils.setActivityTitle(R.string.frag_title_clinics, getActivity());
    }
}
