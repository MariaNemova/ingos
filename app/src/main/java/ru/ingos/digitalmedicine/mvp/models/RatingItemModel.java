package ru.ingos.digitalmedicine.mvp.models;

/**
 * Created by shiya on 02.05.2017.
 */
public class RatingItemModel {

    private String author_name;
    private float rating;
    private String full_text;
    private String date = "23.03.2016";

    public RatingItemModel(String author_name, float rating, String full_text) {
        this.author_name = author_name;
        this.rating = rating;
        this.full_text = full_text;
    }


    public String getAuthor_name() {
        return author_name;
    }

    public float getRating() {
        return rating;
    }

    public String getFull_text() {
        return full_text;
    }

    public String getDate() {
        return date;
    }
}
