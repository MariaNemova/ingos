package ru.ingos.digitalmedicine.menu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.Clinic;
import ru.ingos.digitalmedicine.adapter.ClinicListAdapter;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран списка, списка клиник врачей и прочего!
 */
public class FragmentList extends FragmentBase {

    private final static int LAYOUT = R.layout.fragment_layout_list;

    public FragmentList(){
        super();
        super.setLayout(LAYOUT);
        super.setTitle(R.string.frag_title_clinics);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new ClinicListAdapter(createData()));

        return view;
    }

    private List<Clinic> createData() {
        List<Clinic> data = new ArrayList<>();
        data.add(new Clinic("Clinic 1"));
        data.add(new Clinic("Clinic 2"));
        data.add(new Clinic("Clinic 3"));
        data.add(new Clinic("Clinic 4"));
        data.add(new Clinic("Clinic 5"));
        return data;
    }
}
