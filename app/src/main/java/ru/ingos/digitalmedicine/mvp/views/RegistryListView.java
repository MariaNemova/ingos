package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.RegistryModel;

public interface RegistryListView extends MvpView {

    void setRegistry(List<RegistryModel> registry);
}
