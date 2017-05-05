package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.activities.AddRecipeActivity;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.ui.adapters.RecipeListAdapter;
import ru.ingos.digitalmedicine.ui.models.RecipeModel;

public class FragmentRecipes extends MvpFragment {

    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.rvRecipeslist)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        Utils.setActivityTitle(R.string.frag_title_recipes, getActivity());

        return inflater.inflate(R.layout.fragment_layout_recipes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        recyclerView.setAdapter(new RecipeListAdapter(recipes()));
    }

    // сделал халтурно, попозже исправлю
    private List<RecipeModel> recipes() {
        List<RecipeModel> recipes = new ArrayList<>();
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        recipes.add(new RecipeModel("Арбидол", "2 раза в день"));
        return recipes;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) { return; }
        recipes().add(new RecipeModel(data.getStringExtra("name"), data.getStringExtra("manual")));
    }
}
