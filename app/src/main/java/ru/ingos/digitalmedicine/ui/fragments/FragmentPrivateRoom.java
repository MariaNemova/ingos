package ru.ingos.digitalmedicine.ui.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.presenters.InsuranceInfoPresenter;
import ru.ingos.digitalmedicine.mvp.views.InsuranceInfoView;
import ru.ingos.digitalmedicine.ui.adapters.PrivateRoomMenuAdapter;
import ru.ingos.digitalmedicine.ui.listeners.PrivateRoomMenuListener;

public class FragmentPrivateRoom extends MvpFragment implements InsuranceInfoView{

    @BindView(R.id.private_room_menu)
    RecyclerView menu;

    @BindView(R.id.pr_block_general_info_name)
    TextView tvName;
    @BindView(R.id.pr_block_general_info_number)
    TextView tvInsuranceNumber;
    @BindView(R.id.pr_block_general_info_date)
    TextView tvInsuranceDate;
    @BindView(R.id.pr_block_general_info_avatar)
    ImageView ivAvatar;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "InsuranceInfoPresenter")
    InsuranceInfoPresenter presenter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater, container, savedInstance);
        Utils.setActivityTitle(R.string.frag_title_lk, getActivity());
        if (this instanceof FragmentPrivateRoom)
            Utils.setActivityIcon(0, getActivity());

        return inflater.inflate(R.layout.fragment_private_room, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle instance){
        ButterKnife.bind(this, view);

        menu.setLayoutManager(new LinearLayoutManager(getActivity()));
        menu.setAdapter(new PrivateRoomMenuAdapter(new PrivateRoomMenuListener(menu, getActivity())));
    }



    @Override
    public void setInsuranceInfo(String name, String insuranceNumber, String insuranceDate, Drawable avatar) {
        tvName.setText(name);
        tvInsuranceNumber.setText(insuranceNumber);
        tvInsuranceDate.setText(insuranceDate);
        ivAvatar.setImageDrawable(avatar);
    }

    @Override
    public void laodMethodsWithContext() {
        presenter.setInsuranceInfo(getActivity());
    }


}
