package ru.ingos.digitalmedicine.ui.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.PersonalDataPresenter;
import ru.ingos.digitalmedicine.mvp.views.PersonalDataView;

public class PersonalDataActivity extends MvpAppCompatActivity implements PersonalDataView{

    @BindView(R.id.activity_personal_data_text_view_name) TextView tvFullName;
    @BindView(R.id.activity_personal_data_text_view_birthday) TextView tvBirthday;
    @BindView(R.id.activity_personal_data_text_view_number) TextView tvNumberInsurance;
    @BindView(R.id.activity_personal_data_text_view_job) TextView tvJobPlace;
    @BindView(R.id.activity_personal_data_text_view_end_insurance) TextView tvEndInsurance;
    @BindView(R.id.activity_personal_data_text_view_phone) TextView tvPhoneNumber;

    @BindView(R.id.activity_personal_data_image_btn_edit_number) ImageButton ibEditPhone;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "PersonalDataPresenter")
    PersonalDataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.title_personal_data);
        }

        ibEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(PersonalDataActivity.this)
                        .content(R.string.title_box)
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("Номер телефона", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                tvPhoneNumber.setText(input.toString());
                                Toast.makeText(PersonalDataActivity.this, "Номер телефона изменен!", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void setPersonalData(String fullName, String birthday, String numberInsurance, String jobPlace, String endInsurance, String phoneNumber) {
        tvFullName.setText(fullName);
        tvBirthday.setText(birthday);
        tvNumberInsurance.setText(numberInsurance);
        tvJobPlace.setText(jobPlace);
        tvEndInsurance.setText(endInsurance);
        tvPhoneNumber.setText(phoneNumber);
    }
}
