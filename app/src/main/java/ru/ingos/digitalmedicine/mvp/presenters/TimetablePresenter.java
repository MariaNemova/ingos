package ru.ingos.digitalmedicine.mvp.presenters;

import android.graphics.Color;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.views.TimetableView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@InjectViewState
public class TimetablePresenter extends MvpPresenter<TimetableView> {

    private int doctorId = -1;

    private List<CalendarEvent> mTimetable = new ArrayList<>();

    @Override
    public void onFirstViewAttach(){
        Utils.logPresenterCreated(this.getClass());
    }

    public void setDoctorId(int doctorId){
        this.doctorId = doctorId;
    }

    public void loadTimtable(){
        if(doctorId!=-1){
            loadTimetable();
            getViewState().addTimetable(new ArrayList<>(mTimetable));
        }
    }

    private void loadTimetable(){
        for(int i = 0; i<30; i++){
            addRandomEvent(i, 30);
        }
    }

    private void addRandomEvent(long id, int nextDaysAmount){
        int day = (int)(nextDaysAmount*Utils.GLOBAL_RANDOM.nextFloat());
        int hour = (int)(8+10*Utils.GLOBAL_RANDOM.nextFloat());

        Calendar start = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, hour);
        start.set(Calendar.MINUTE, 0);
        start.add(Calendar.DAY_OF_MONTH, day);

        Calendar end = Calendar.getInstance();
        end.set(Calendar.HOUR_OF_DAY, hour);
        end.set(Calendar.MINUTE, 0);
        end.add(Calendar.DAY_OF_MONTH, day);

        BaseCalendarEvent calendarEvent = new BaseCalendarEvent(id, day%2==0?Color.GRAY:Color.DKGRAY,
                hour+":00-"+hour+":30","", "Иванов Иван Иванович",
                start.getTimeInMillis(), end.getTimeInMillis(), 0, "30");

        this.mTimetable.add(calendarEvent);
    }

}
