package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран настроек
 */
public class FragmentSettings extends MvpFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_settings, getActivity());
        return inflater.inflate(R.layout.fragment_layout_settings, container, false);
    }

}
