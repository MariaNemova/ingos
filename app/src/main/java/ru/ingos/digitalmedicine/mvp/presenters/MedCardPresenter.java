package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.MedCardModel;
import ru.ingos.digitalmedicine.mvp.views.MedCardView;

@InjectViewState
public class MedCardPresenter extends MvpPresenter<MedCardView> {

    private MedCardModel medCard;

    private void loadMedCard(){
        medCard = new MedCardModel("14.05.2017",
                "14:30",
                "Ул. Пушкина 5",
                "Боли в животе",
                "Гастрит",
                "Иван Иванов",
                Arrays.asList("1", "2", "3", "4", "5"));
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(MedCardPresenter.class);
        setMedCard();
    }

    private void setMedCard() {
        loadMedCard();
        getViewState().setMedCard(
                medCard.getDate(),
                medCard.getTime(),
                medCard.getAddress(),
                medCard.getReports(),
                medCard.getDiagnosis(),
                medCard.getDocName(),
                medCard.getRecipes()
        );
    }
}
