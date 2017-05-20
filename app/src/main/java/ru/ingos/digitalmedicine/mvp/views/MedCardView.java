package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface MedCardView extends MvpView{


    void setMedCard(String date, String time, String address, String reports, String diagnosis, String docName, List<String> recipes);
}
