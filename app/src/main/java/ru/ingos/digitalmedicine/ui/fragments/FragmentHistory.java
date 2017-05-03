package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;

import java.util.zip.Inflater;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран карты пциэнта, содержащий историю посещений, текущие направления, рецепты и прочее.
 */
public class FragmentHistory extends MvpFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        Utils.setActivityTitle(R.string.frag_title_history, getActivity());
        return inflater.inflate(R.layout.fragment_layout_history, container, false);
    }

}
