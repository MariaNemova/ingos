package ru.ingos.digitalmedicine.mvp.views;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.ingos.digitalmedicine.mvp.models.RecipeModel;

public interface RecipeListView extends MvpView {

    void setRecipes(List<RecipeModel> recipes);
}
