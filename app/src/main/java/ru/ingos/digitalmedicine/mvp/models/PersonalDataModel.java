package ru.ingos.digitalmedicine.mvp.models;

import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;

public class PersonalDataModel {

    private String fullName;
    private String birthday;
    private String numberInsurance;
    private String jobPlace;
    private String endInsurance;
    private String phoneNumber;

    private boolean errorWhileSettingNumber = false;

    public PersonalDataModel(String fullName, String birthday, String numberInsurance, String jobPlace, String endInsurance, String phoneNumber) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.numberInsurance = numberInsurance;
        this.jobPlace = jobPlace;
        this.endInsurance = endInsurance;
        setPhoneNumber(phoneNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNumberInsurance() {
        return numberInsurance;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public String getEndInsurance() {
        return endInsurance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.errorWhileSettingNumber = false;
        final Mask mask = new Mask("+7([000])[000]-[00]-[00]");
        final Mask.Result result = mask.apply(
                new CaretString(
                        phoneNumber,
                        phoneNumber.length()
                ),
                false
        );
        if(result.getComplete()){
            this.phoneNumber = result.getFormattedText().getString();
        }else {
            this.errorWhileSettingNumber = true;
        }
    }

    public boolean isNumSetted(){
        return !this.errorWhileSettingNumber;
    }
}
