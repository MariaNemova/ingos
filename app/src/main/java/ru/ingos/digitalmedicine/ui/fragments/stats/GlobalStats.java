package ru.ingos.digitalmedicine.ui.fragments.stats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class GlobalStats extends MVP4Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_fragment_global_stats, container, false);
    }
}
