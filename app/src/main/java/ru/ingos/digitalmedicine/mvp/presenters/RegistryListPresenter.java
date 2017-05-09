package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RegistryModel;
import ru.ingos.digitalmedicine.mvp.views.RegistryListView;

@InjectViewState //корень зла, не забывать
public class RegistryListPresenter extends MvpPresenter<RegistryListView> {

    private List<RegistryModel> registry;

    public RegistryListPresenter(){
        super();
    }

    //мы имитируем данные, в реальности тут должно быть что-то что подключается к интернету, диску итд.
    private List<RegistryModel> loadRegistry (){
        List<RegistryModel> registry = new ArrayList<>();

        registry.add(new RegistryModel("11 мая, 2017 год. 12:00", "ЛОР", "Ул. Пушкина, д. 12, каб. 112"));
        registry.add(new RegistryModel("16 мая, 2017 год. 15:00", "Уролог", "Ул. Красная, д. 25, каб. 302"));
        registry.add(new RegistryModel("1 июня, 2017 год. 11:00", "Окулист", "Ул. Семеновская, д. 31, каб. 202"));

        return registry;
    }

    //Этот метод вызывается автоматически при первом присоединении
    @Override
    public void onFirstViewAttach() {
        Utils.logPresenterCreated(RegistryListPresenter.class);
        this.registry = loadRegistry();
        setRegistry();
    }

    public void setRegistry() {
        getViewState().setRegistry(new ArrayList<>(registry));
    }
}
