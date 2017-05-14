package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.adapters.PrivateRoomMenuAdapter;
import ru.ingos.digitalmedicine.ui.listeners.PrivateRoomMenuListener;

public class FragmentPrivateRoom extends MvpFragment {

    @BindView(R.id.private_room_menu)
    RecyclerView menu;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater, container, savedInstance);
        Utils.setActivityTitle(R.string.frag_title_lk, getActivity());

        return inflater.inflate(R.layout.fragment_private_room, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle instance){
        ButterKnife.bind(this, view);

        menu.setLayoutManager(new LinearLayoutManager(getActivity()));
        menu.setAdapter(new PrivateRoomMenuAdapter(new PrivateRoomMenuListener(menu)));
    }

}
