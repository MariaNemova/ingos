package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RecipeModel;
import ru.ingos.digitalmedicine.mvp.presenters.RecipeListPresenter;
import ru.ingos.digitalmedicine.mvp.views.RecipeListView;
import ru.ingos.digitalmedicine.ui.activities.AddRecipeActivity;
import ru.ingos.digitalmedicine.ui.adapters.RecipeListAdapter;

public class FragmentRecipes extends MvpFragment implements RecipeListView {

    @BindView(R.id.fragment_recipes_fab)
    FloatingActionButton fabBtnRecipe;
    @BindView(R.id.fragment_recipes_recycler_view)
    RecyclerView rvRecipeslist;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "RecipeListPresenter")
    RecipeListPresenter presenter;

    private RecipeListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_recipes, getActivity());

        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        fabBtnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        mAdapter = new RecipeListAdapter(getActivity());

        rvRecipeslist.setAdapter(mAdapter);
        rvRecipeslist.setLayoutManager(new LinearLayoutManager(null));

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            Log.d(IngosApplication.DEBUG_TAG, "Add recipe form returned not data!");
            return;
        }
        RecyclerView.Adapter adapter = rvRecipeslist.getAdapter();
        if(adapter instanceof RecipeListAdapter){
            ((RecipeListAdapter) adapter).addItem(data.getStringExtra("name"), data.getStringExtra("manual"));
        }
    }

    @Override
    public void setRecipes(List<RecipeModel> recipes) {
        mAdapter.setRecipes(recipes);
    }
}
