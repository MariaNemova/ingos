package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.TimetablePresenter;
import ru.ingos.digitalmedicine.mvp.views.TimetableView;
import ru.ingos.digitalmedicine.ui.listeners.TimetableListener;

import java.util.List;

public class NewRegistryActivity extends MvpAppCompatActivity implements TimetableView{

    @InjectPresenter
    TimetablePresenter presenter;

    @BindView(R.id.activty_new_registry_week_view) WeekView wvTimetable;
    private TimetableListener listener;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        int doctorId = getIntent().getIntExtra(IngosApplication.EXTRA_DOCTOR_ID, -1);
        if(doctorId != -1){
            presenter.setDoctorId(doctorId);
        }else{
            Log.w(IngosApplication.DEBUG_TAG, "Can't find doctor for timetable");
        }


        setContentView(R.layout.activity_new_registry);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(R.string.activity_new_registry);
        }

        ButterKnife.bind(this);


        listener = new TimetableListener();
        presenter.loadTimtable(123);
        wvTimetable.setMonthChangeListener(listener);
        wvTimetable.setOnEventClickListener(listener);
        wvTimetable.setEventLongPressListener(listener);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

    @Override
    public void addTimetable(List<WeekViewEvent> events) {
        if(this.listener!=null){
            Log.d(IngosApplication.DEBUG_TAG, "Put info into timetable");
            this.listener.setTimetable(events);
            this.wvTimetable.notifyDatasetChanged();

        }
    }
}
