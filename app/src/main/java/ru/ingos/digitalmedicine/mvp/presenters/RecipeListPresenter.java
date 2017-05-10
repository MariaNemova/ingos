package ru.ingos.digitalmedicine.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RecipeModel;
import ru.ingos.digitalmedicine.mvp.views.RecipeListView;

@InjectViewState
public class RecipeListPresenter extends MvpPresenter<RecipeListView> {

    private List<RecipeModel> recipes;

    private List<RecipeModel> loadRecipes() {
        List<RecipeModel> recipes = new ArrayList<>();
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        return recipes;
    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(RecipeListPresenter.class);
        this.recipes = loadRecipes();
        setRecipes();
    }

    public void setRecipes() {
        getViewState().setRecipes(new ArrayList<>(recipes));
    }
}
