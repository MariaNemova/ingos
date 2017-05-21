package ru.ingos.digitalmedicine.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.activities.ChatActivity;
import ru.ingos.digitalmedicine.ui.adapters.FragmentMainAdapter;
import ru.ingos.digitalmedicine.ui.listeners.MainFragmentPagerListener;

public class FragmentMain extends MVP4Fragment{

    @BindView(R.id.fragment_main_pager) ViewPager pager;

    private Unbinder unbinder;
    private FragmentMainAdapter adapter;

    public FragmentMain(){
        super();
    }

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance){
        unbinder = ButterKnife.bind(this, view);
        Activity activity = getActivity();
        adapter = new FragmentMainAdapter(getChildFragmentManager());
        if(activity instanceof AppCompatActivity){
            pager.addOnPageChangeListener(new MainFragmentPagerListener(((AppCompatActivity) activity).getSupportActionBar()));
        }
        pager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.chat, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.chat:
                startActivity(new Intent(getActivity(), ChatActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }
    
    
}
