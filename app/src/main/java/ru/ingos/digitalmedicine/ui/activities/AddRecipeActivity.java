package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import ru.ingos.digitalmedicine.R;

public class AddRecipeActivity extends MvpAppCompatActivity {

    @BindView(R.id.activity_add_recipe_btn_add)
    Button btn_add;
    @BindView(R.id.activity_add_recipe_edit_name)
    EditText etName;
    @BindView(R.id.activity_add_recipe_edit_manual)
    EditText etManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.title_recipe_add);

        ButterKnife.bind(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("manual", etManual.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
