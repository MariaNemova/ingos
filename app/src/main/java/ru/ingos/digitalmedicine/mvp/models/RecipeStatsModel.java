package ru.ingos.digitalmedicine.mvp.models;

public class RecipeStatsModel {

    private String recipeName;
    private String recipeStats;

    public RecipeStatsModel(String recipeName, String recipeStats) {
        this.recipeName = recipeName;
        this.recipeStats = recipeStats;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeStats() {
        return recipeStats;
    }
}
