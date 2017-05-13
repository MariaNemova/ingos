package ru.ingos.digitalmedicine.mvp.views;

import com.alamkanak.weekview.WeekViewEvent;
import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface TimetableView extends MvpView {

    void addTimetable(List<WeekViewEvent> events);

}
