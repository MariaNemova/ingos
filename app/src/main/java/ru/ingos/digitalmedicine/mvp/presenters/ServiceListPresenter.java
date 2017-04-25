package ru.ingos.digitalmedicine.mvp.presenters;

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

    private List<Service> loadServices(){
        //TODO необходимо правильно описать выкачивание доступных услуг из БД
        //Выкачивание должно производить на основе каких либо id (страховки и клиники)
        List<Service> services = new ArrayList<>();
        services.add(new Service("Трапевт", "что-то"));
        services.add(new Service("Хирург", "что-то"));
        services.add(new Service("Травматолог", "что-то"));
        services.add(new Service("Стоматолог", "что-то"));
        services.add(new Service("ЛОР", "что-то"));
        services.add(new Service("Горилла", "что-то"));
        services.add(new Service("Еще что-то", "что-то"));
        services.add(new Service("Название 10", "что-то"));

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
