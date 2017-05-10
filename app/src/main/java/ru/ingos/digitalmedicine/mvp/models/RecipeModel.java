package ru.ingos.digitalmedicine.mvp.models;

public class RecipeModel {

    String recipeName;
    String recipeManual;

    public RecipeModel(String recipeName, String recipeManual) {
        this.recipeName = recipeName;
        this.recipeManual = recipeManual;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeManual() {
        return recipeManual;
    }
}
