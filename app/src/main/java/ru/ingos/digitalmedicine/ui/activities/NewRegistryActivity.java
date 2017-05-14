package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
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
import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.TimetablePresenter;
import ru.ingos.digitalmedicine.mvp.views.TimetableView;
import ru.ingos.digitalmedicine.ui.listeners.TimetableListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class NewRegistryActivity extends MvpAppCompatActivity implements TimetableView, CalendarPickerController{

    @InjectPresenter TimetablePresenter presenter;

    @BindView(R.id.activity_new_registry_agenda_calendar) AgendaCalendarView timetable;

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
        presenter.loadTimtable();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

    @Override
    public void addTimetable(List<CalendarEvent> events) {
        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        maxDate.add(Calendar.MONTH, 1);


        timetable.init(events, minDate, maxDate, Locale.getDefault(), this);
    }

    @Override
    public void onDaySelected(DayItem dayItem) {

    }

    @Override
    public void onEventSelected(CalendarEvent calendarEvent) {
        Intent intent = new Intent(this, RegistryInfoActivity.class);
        intent.putExtra(IngosApplication.EXTRA_IS_CONFIRMATION, true);

        startActivity(intent);
    }

    @Override
    public void onScrollToDate(Calendar calendar) {

    }
}
