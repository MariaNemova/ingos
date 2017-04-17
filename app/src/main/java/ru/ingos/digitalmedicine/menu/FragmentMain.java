package ru.ingos.digitalmedicine.menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ru.ingos.digitalmedicine.Activity.SpecialtyActivity;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Фрагмент, представляющий собой главный экран приложения. На нем располагаются ключевые кнопки, информация о
 * состоянии страховки и последняя активная запись к врачу.
 */
public class FragmentMain extends FragmentBase implements AdapterView.OnClickListener{

    private static int[] BLOCKS = {
            R.id.block_insuranse
    };

    public FragmentMain(){
        super();
        super.setLayout(R.layout.fragment_layout_main);
        super.setTitle(R.string.frag_title_main);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse){
        View temp = super.onCreateView(inflater,container,savedInstanse);

        for (int id:BLOCKS){
            LinearLayout ll = (LinearLayout) this.globalView.findViewById(id);
            ll.setOnClickListener(this);
        }

        RelativeLayout main_btn  = (RelativeLayout) this.globalView.findViewById(R.id.btn_register);
        main_btn.setOnClickListener(this);

        return temp;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.block_insuranse:
                super.changeView(FragmentPrivateRoom.class);
                break;
            case R.id.btn_register:
                startActivity(new Intent(getActivity(), SpecialtyActivity.class));
                break;

            default:
                break;
        }
    }
}
