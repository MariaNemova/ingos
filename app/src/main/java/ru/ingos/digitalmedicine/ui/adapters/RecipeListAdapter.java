package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.models.RecipeModel;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeHolder>{

    private List<RecipeModel> recipes;

    public RecipeListAdapter(List<RecipeModel> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);

        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeHolder holder, int position) {
        holder.tvRecipeName.setText(recipes.get(position).getRecipeName());
        holder.tvRecipeManual.setText(recipes.get(position).getRecipeManual());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeHolder extends RecyclerView.ViewHolder {

        CardView cVRecipe;
        TextView tvRecipeName;
        TextView tvRecipeManual;

        public RecipeHolder(View itemView) {
            super(itemView);

            cVRecipe = (CardView) itemView.findViewById(R.id.cVRecipe);
            tvRecipeName = (TextView) itemView.findViewById(R.id.tvRecipeName);
            tvRecipeManual = (TextView) itemView.findViewById(R.id.tvRecipeManual);
        }
    }

}
