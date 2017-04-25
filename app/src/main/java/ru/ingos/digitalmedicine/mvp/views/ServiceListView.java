package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;
import ru.ingos.digitalmedicine.mvp.models.Service;

import java.util.List;

public interface ServiceListView extends MvpView{

    void setServices(List<Service> services);

}
