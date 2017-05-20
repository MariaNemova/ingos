package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.MedCardPresenter;
import ru.ingos.digitalmedicine.mvp.views.MedCardView;
import ru.ingos.digitalmedicine.ui.adapters.RecipeFromMCAdapter;

public class MedCardActivity extends MvpAppCompatActivity implements MedCardView{

    @BindView(R.id.activity_med_card_list_view) ListView lvRecipes;
    @BindView(R.id.activity_med_card_text_view_date) TextView tvDate;
    @BindView(R.id.activity_med_card_text_view_time) TextView tvTime;
    @BindView(R.id.activity_med_card_text_view_address) TextView tvAddress;
    @BindView(R.id.activity_med_card_text_view_reports) TextView tvReports;
    @BindView(R.id.activity_med_card_text_view_diagnosis) TextView tvDiagnosis;
    @BindView(R.id.activity_med_card_text_view_doc_name) TextView tvDocName;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "MedCardPresenter")
    MedCardPresenter presenter;



    private RecipeFromMCAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_card);
        ButterKnife.bind(this);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.full_information_from_mc);

        mAdapter = new RecipeFromMCAdapter(getApplicationContext());

        lvRecipes.setAdapter(mAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void setMedCard(String date, String time, String address, String reports, String diagnosis, String docName, List<String> recipes) {

        tvDate.setText(date);
        tvTime.setText(time);
        tvAddress.setText(address);
        tvReports.setText(reports);
        tvDiagnosis.setText(diagnosis);
        tvDocName.setText(docName);
        mAdapter.setRecipes(recipes);
        mAdapter.notifyDataSetChanged();

    }
}
