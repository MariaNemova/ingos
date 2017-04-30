package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ingos.digitalmedicine.R;

public class FragmentRecipes extends FragmentBase {

    final static int LAYOUT = R.layout.fragment_layout_recipes;

    public FragmentRecipes(){
        super();
        super.setLayout(LAYOUT);
        super.setTitle(R.string.frag_title_recipes);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        super.onCreateView(inflater,container,savedInstanse);

        return null;
    }
}
