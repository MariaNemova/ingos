package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;

import java.util.List;

public interface TimetableView extends MvpView {

    void addTimetable(List<CalendarEvent> events);

}
