package ru.ingos.digitalmedicine.mvp.presenters;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.mvp.models.Service;
import ru.ingos.digitalmedicine.mvp.views.ServiceListView;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class ServiceListPresenter extends MvpPresenter<ServiceListView> {

    private List<Service> services;

    //имитирую колбек. в будущем будет заменено на асинхронный запрос.
    private boolean updated = false;
    private boolean requested = false;

    public ServiceListPresenter(){
        super();

        Log.d("MOJAR", "Создан презентер списка!");
    }

    private List<Service> loadServices(){
        //TODO необходимо правильно описать выкачивание доступных услуг из БД
        //Выкачивание должно производить на основе каких либо id (страховки и клиники)
        List<Service> services = new ArrayList<>();
        services.add(new Service("Трапевт", "что-то"));
        services.add(new Service("Хирурге", "что-то"));
        services.add(new Service("Тралог", "что-то"));
        services.add(new Service("Стоматолог", "что-то"));
        services.add(new Service("ЛОР", "что-то"));
        services.add(new Service("Трапевт2", "что-то"));
        services.add(new Service("Хирург2", "что-то"));
        services.add(new Service("Травматолог2", "что-то"));
        services.add(new Service("Стоматолог2", "что-то"));
        services.add(new Service("ЛОР2", "что-то"));

        return services;
    }

    @Override
    public void onFirstViewAttach(){
        this.services = loadServices();
        updated = true;
        //имитирую колбек. в будущем будет заменено на асинхронный запрос.
        if(requested){
            setServices();
        }
    }

    public void setServices(){
        if(updated){
            //разрываю ссылку
            getViewState().setServices(new ArrayList<>(services));
            updated = false;
            requested = false;
        }
        else
            requested = true;
    }
}
