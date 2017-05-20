package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.MedCardModel;

public class RecipeFromMCAdapter extends BaseAdapter {

    private List<String> recipes;

    public void setRecipes(List<String> recipes) {
        this.recipes = recipes;
    }

    private LayoutInflater inflater;

    public RecipeFromMCAdapter(Context context){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return recipes == null ? 0:recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.item_speciality, parent, false);

        TextView tvRecipe = (TextView) view.findViewById(R.id.item_speciality_text_view_spec);
        tvRecipe.setText(this.recipes.get(position));

        return view;
    }
}
