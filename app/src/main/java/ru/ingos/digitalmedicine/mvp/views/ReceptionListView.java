package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.ReceptionModel;

public interface ReceptionListView extends MvpView {

    void setReceptions(List<ReceptionModel> receptions);
}
