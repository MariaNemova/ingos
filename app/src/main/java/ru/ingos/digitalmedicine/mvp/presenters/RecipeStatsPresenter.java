package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RecipeStatsModel;
import ru.ingos.digitalmedicine.mvp.views.RecipeStatsView;

@InjectViewState
public class RecipeStatsPresenter extends MvpPresenter<RecipeStatsView> {

    private List<RecipeStatsModel> recipeStats;

    private List<RecipeStatsModel> loadRecipeStats(){
        List<RecipeStatsModel> recipeStats = new ArrayList<>();

        recipeStats.add(new RecipeStatsModel("Арбидол", "1 раз"));
        recipeStats.add(new RecipeStatsModel("Синие таблетки", "2 раза"));
        recipeStats.add(new RecipeStatsModel("Розовые таблетки", "3 раза"));
        recipeStats.add(new RecipeStatsModel("Голубые таблетки", "4 раза"));

        return recipeStats;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(RecipeListPresenter.class);
        this.recipeStats = loadRecipeStats();
        setRecipeStats();
    }

    private void setRecipeStats() {
        getViewState().setRecipeStats(new ArrayList<>(recipeStats));
    }
}
