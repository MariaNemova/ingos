package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.RecipeStatsModel;

public interface RecipeStatsView extends MvpView {

    void setRecipeStats(List<RecipeStatsModel> recipeStats);
}
