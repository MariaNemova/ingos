package ru.ingos.digitalmedicine.mvp.presenters;

import com.alamkanak.weekview.WeekViewEvent;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.views.TimetableView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class TimetablePresenter extends MvpPresenter<TimetableView> {

    private int doctorId = -1;
    private List<WeekViewEvent> timetable = new ArrayList<>();

    @Override
    public void onFirstViewAttach(){
        Utils.logPresenterCreated(this.getClass());
    }

    public void setDoctorId(int doctorId){
        this.doctorId = doctorId;
    }

    public void loadTimtable(int currentDate){
        if(doctorId!=-1){
            loadTimetable();
            getViewState().addTimetable(new ArrayList<>(timetable));
        }
    }

    private void loadTimetable(){
        timetable.add(new WeekViewEvent(1, "Записаться", 2017, 5, 14,13,0,2017,5,14,13,30));
        timetable.add(new WeekViewEvent(1, "Записаться", 2017, 5, 14,14,0,2017,5,14,14,30));
        timetable.add(new WeekViewEvent(1, "Записаться", 2017, 5, 14,16,0,2017,5,14,16,30));
    }

}
