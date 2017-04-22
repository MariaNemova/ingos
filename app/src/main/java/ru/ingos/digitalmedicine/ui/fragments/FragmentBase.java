package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 * Фрагмент от которого будут наследовать все основные фрагменты приложения.
 *
 * Очень прошу наследовать все фрагменты от этого, это сделает иирархию приложения чистой.
 * Множество типовых, для данного приложения, методов не будут дублированы.
 */
public class FragmentBase extends MvpFragment {

    private int layout_pointer = R.layout.fragment_layout_base;
    private int title_pointer = R.string.debug_text;
    protected View view;
    private MainActivity actv;
    protected View globalView;

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanse)
    {
        super.onCreate(savedInstanse);
        this.actv = (MainActivity)getActivity();
    }

    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanse){
        super.onCreateView(inflater,container,savedInstanse);
        this.actv.cahngeToolbar(title_pointer);

        globalView = inflater.inflate(this.layout_pointer,container,false);
        return globalView;
    }

    protected void setLayout(int layout_pointer)
    {
        this.layout_pointer = layout_pointer;
    }

    void setTitle(int title_pointer){
        this.title_pointer = title_pointer;
    }

    @Override
    @CallSuper
    public void onDestroy(){
        this.actv = null;
        this.globalView = null;

        super.onDestroy();
    }

    void changeView(Class<? extends FragmentBase> viewClass){
        actv.bindFragment(viewClass, true);
    }

//    protected MainActivity getActivityLink(){
//        if(this.actv!=null){
//            return this.actv;
//        }
//        //Если фрагмент еще не успел сохранить Activity
//        throw new RuntimeException("No Activity found in current fragment.");
//    }

}
