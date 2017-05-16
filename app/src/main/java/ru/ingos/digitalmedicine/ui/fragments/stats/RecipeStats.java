package ru.ingos.digitalmedicine.ui.fragments.stats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.RecipeStatsModel;
import ru.ingos.digitalmedicine.mvp.presenters.RecipeStatsPresenter;
import ru.ingos.digitalmedicine.mvp.views.RecipeStatsView;
import ru.ingos.digitalmedicine.ui.adapters.RecipeStatsAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class RecipeStats extends MVP4Fragment implements RecipeStatsView{

    @BindView(R.id.pager_fragment_recipe_stats_recycler_view)
    RecyclerView rvRecipeStats;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "RecipeStatsPresenter")
    RecipeStatsPresenter presenter;

    private RecipeStatsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_fragment_recipe_stats, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        mAdapter = new RecipeStatsAdapter(getContext());

        rvRecipeStats.setLayoutManager(new LinearLayoutManager(null));
        rvRecipeStats.setAdapter(mAdapter);

    }

    @Override
    public void setRecipeStats(List<RecipeStatsModel> recipeStats) {
        mAdapter.setRecipeStats(recipeStats);
    }
}
