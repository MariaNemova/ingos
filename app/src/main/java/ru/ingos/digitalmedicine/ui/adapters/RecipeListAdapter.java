package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RecipeModel;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeHolder>{

    private List<RecipeModel> recipes;

    public void setRecipes(List<RecipeModel> recipes) {
        this.recipes = recipes;
    }

    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context) {
        super();

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
    }

    @Override
    public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);

        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeHolder holder, int position) {
        RecipeModel current = recipes.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cvRecipe;
        TextView tvRecipeName;
        TextView tvRecipeManual;
        ImageView ivDel;
        private int position;
        private RecipeModel currentObject;

        public RecipeHolder(View itemView) {
            super(itemView);

            cvRecipe = (CardView) itemView.findViewById(R.id.item_recipe_card_view);
            tvRecipeName = (TextView) itemView.findViewById(R.id.item_recipe_text_view_name);
            tvRecipeManual = (TextView) itemView.findViewById(R.id.item_recipe_text_view_manual);
            ivDel = (ImageView) itemView.findViewById(R.id.item_list_image_view_del);
        }

        public void setData(RecipeModel currentObject, int position){
            this.tvRecipeName.setText(currentObject.getRecipeName());
            this.tvRecipeManual.setText(currentObject.getRecipeManual());
            this.position = position;
            this.currentObject = currentObject;
        }

        public void setListeners(){
            ivDel.setOnClickListener(RecipeHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.item_list_image_view_del:
                    removeItem(position);
                    break;
            }
        }
    }

    public void removeItem(int position){
        recipes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, recipes.size());

    }

    public void addItem(String name, String manual){
        if(name.equals("")) return;

        RecipeModel item = new RecipeModel(name, manual);
        recipes.add(item);
        notifyItemRangeInserted(recipes.size()-2, 1);
        notifyDataSetChanged();
    }
}
