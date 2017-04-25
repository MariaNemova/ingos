package ru.ingos.digitalmedicine.ui.layouts;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.adapters.ServiceListAdapter;

import java.util.List;

public class CustomPager extends ViewPager {
    private View mCurrentView;

    public CustomPager(Context context) {
        super(context);
    }

    public CustomPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        ListView listView = (ListView)mCurrentView.findViewById(R.id.clinic_info_services_list);
        int height = 0;
        if(listView != null){
            ServiceListAdapter adapter = (ServiceListAdapter)listView.getAdapter();
            if(adapter != null){
                height = adapter.getCount()*64;//FIXME неверный способ вычсления высоты! заменить! (сейчас нет времени на исправления)
            }else {
                Log.d("MOJAR", "No adapter on list view!");
            }
        }else {
            mCurrentView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = mCurrentView.getMeasuredHeight();
            if (h > height) height = h;
        }



        Log.d("MOJAR", "Layout height: "+height);

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void measureCurrentView(View currentView) {
        mCurrentView = currentView;
        requestLayout();
    }
}
