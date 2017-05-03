package ru.ingos.digitalmedicine.ui.models;

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

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeManual() {
        return recipeManual;
    }

    public void setRecipeManual(String recipeManual) {
        this.recipeManual = recipeManual;
    }
}
