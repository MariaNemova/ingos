package ru.ingos.digitalmedicine.ui.listeners;

import android.graphics.RectF;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimetableListener implements MonthLoader.MonthChangeListener,
        WeekView.EventClickListener, WeekView.EventLongPressListener, WeekView.ScrollListener {

    private List<WeekViewEvent> timetable;

    public void setTimetable(List<WeekViewEvent> timetable) {
        this.timetable = timetable;
    }

    @Override
    public List<WeekViewEvent> onMonthChange(int i, int i1) {
        return timetable!=null?timetable:new ArrayList<WeekViewEvent>();
    }

    @Override
    public void onEventClick(WeekViewEvent weekViewEvent, RectF rectF) {

    }

    @Override
    public void onEventLongPress(WeekViewEvent weekViewEvent, RectF rectF) {

    }

    @Override
    public void onFirstVisibleDayChanged(Calendar calendar, Calendar calendar1) {

    }
}
