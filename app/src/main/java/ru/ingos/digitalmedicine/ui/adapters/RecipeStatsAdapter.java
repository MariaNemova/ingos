package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RecipeStatsModel;

public class RecipeStatsAdapter  extends RecyclerView.Adapter<RecipeStatsAdapter.RecipeStatsHolder>{

    private List<RecipeStatsModel> recipeStats;
    private LayoutInflater mInflater;

    public RecipeStatsAdapter(Context context) {
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setRecipeStats(List<RecipeStatsModel> recipeStats) {
        this.recipeStats = recipeStats;
    }

    @Override
    public RecipeStatsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new RecipeStatsHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeStatsHolder holder, int position) {
        RecipeStatsModel current = recipeStats.get(position);
        holder.setData(current);
    }

    @Override
    public int getItemCount() {
        return recipeStats.size();
    }

    public class RecipeStatsHolder extends RecyclerView.ViewHolder {

        private TextView tvRecipeName;
        private TextView tvRecipeStats;

        public RecipeStatsHolder(View itemView) {
            super(itemView);

            tvRecipeName = (TextView) itemView.findViewById(R.id.tvNameClinic);
            tvRecipeStats = (TextView) itemView.findViewById(R.id.tvAddresClinic);

        }

        public void setData(RecipeStatsModel currentObject){
            this.tvRecipeName.setText(currentObject.getRecipeName());
            this.tvRecipeStats.setText(currentObject.getRecipeStats());
        }
    }
}
