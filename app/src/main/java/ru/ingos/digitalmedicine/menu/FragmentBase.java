package ru.ingos.digitalmedicine.menu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ru.ingos.digitalmedicine.MainActivity;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 * Фрагмент от которого будут наследовать все основные фрагменты приложения.
 *
 * Очень прошу наследовать все фрагменты от этого, это сделает иирархию приложения чистой.
 * Множество типовых, для данного приложения, методов не будут дублированы.
 */
public class FragmentBase extends Fragment {

    private int layout_pointer = R.layout.fragment_layout_base;
    private int title_pointer = R.string.debug_text;


    @Override
    public void onCreate(Bundle savedInstanse){
        super.onCreate(savedInstanse);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse){
        MainActivity actv = (MainActivity)getActivity();
        actv.cahngeToolbar(title_pointer);

        return inflater.inflate(this.layout_pointer,container,false);
    }

    protected void setLayout(int layout_pointer)
    {
        this.layout_pointer = layout_pointer;
    }

    protected void setTitle(int title_pointer){
        this.title_pointer = title_pointer;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        this.layout_pointer = 0;
        this.title_pointer = 0;
    }

}
