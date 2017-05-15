package ru.ingos.digitalmedicine.ui.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.RecipeModel;
import ru.ingos.digitalmedicine.mvp.presenters.RecipeListPresenter;
import ru.ingos.digitalmedicine.mvp.views.RecipeListView;
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
                addRecipe();
            }
        });

        mAdapter = new RecipeListAdapter(getActivity());

        rvRecipeslist.setAdapter(mAdapter);
        rvRecipeslist.setLayoutManager(new LinearLayoutManager(null));

    }

    @Override
    public void setRecipes(List<RecipeModel> recipes) {
        mAdapter.setRecipes(recipes);
    }

    private void addRecipe() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setTitle(R.string.title_recipe_add);
        dialog.setContentView(R.layout.input_recipe_box);
        final EditText etDrugName =(EditText) dialog.findViewById(R.id.input_box_edit_text_drug_name);
        final EditText etDrugManual =(EditText) dialog.findViewById(R.id.input_box_edit_text_drug_manual);
        Button btnAddRecipe = (Button) dialog.findViewById(R.id.input_box_add_recipe);
        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.Adapter adapter = rvRecipeslist.getAdapter();
                if(adapter instanceof RecipeListAdapter){
                    ((RecipeListAdapter) adapter).addItem(etDrugName.getText().toString(), etDrugManual.getText().toString());
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
