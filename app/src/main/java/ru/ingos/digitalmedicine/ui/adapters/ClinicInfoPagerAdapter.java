package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.ingos.digitalmedicine.R;

public class ClinicInfoPagerAdapter extends PagerAdapter{
    private Context mContext;
    private int windowHeight;

    public ClinicInfoPagerAdapter(Context context, int windowHeight){
        this.mContext = context;
        this.windowHeight = windowHeight;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_layout_private_room, container, false);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        Log.d("MOJAR", "Remove: "+position);
        container.removeView((View) object);
    }
}
