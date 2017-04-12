package ru.ingos.digitalmedicine.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран списка, списка клиник врачей и прочего!
 */
public class FragmentList extends FragmentBase {

    public FragmentList(){
        super();
        super.setLayout(R.layout.fragment_layout_list);
        super.setTitle(R.string.frag_title_clinics);
    }

}
