package ru.ingos.digitalmedicine.common;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.util.Log;
import com.arellomobile.mvp.MvpPresenter;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.ui.activities.FragmentHolderActivity;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static final Random GLOBAL_RANDOM = new Random();

    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static long daysBetween(long start, long end){
        return TimeUnit.DAYS.convert(start-end, TimeUnit.MILLISECONDS);
    }

    public static String getCorrectDaysString(long days_between){
        String btw_str = String.valueOf(days_between);

        int last_digit = (int)days_between % 10;
        switch (last_digit){
            case 2:
            case 3:
            case 4:
                btw_str+=" дня";
                break;
            case 1:
                btw_str += "день";
                break;
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                btw_str+=" дней";
                break;
        }

        return btw_str;
    }

    public static int getStatusBarHeight(Resources resources){
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }else {
            //FIXME: не ронять приложение. найти выход из ситуации
            throw new RuntimeException("StatusBar size not found!");
        }
    }

    public static void setActivityTitle(int pointer, Activity activity){
        ActionBar actionBar = null;
        if(activity instanceof MainActivity) actionBar = ((MainActivity) activity).getSupportActionBar();
        if(activity instanceof FragmentHolderActivity) actionBar = ((FragmentHolderActivity) activity).getSupportActionBar();

        if(actionBar != null){
            actionBar.setTitle(pointer);
        } else {
            Log.w(IngosApplication.DEBUG_TAG, "Can't setup activity\'s title! Activity has wrong class");
        }
    }

    public static void logPresenterCreated(Class<? extends MvpPresenter> presenterClass){
        Log.d(IngosApplication.DEBUG_TAG, "Presenter: \""+presenterClass.getSimpleName()+"\" created");
    }

    public static void showFragmentInActivity(Class<? extends Fragment> fragmentClass, Activity parent){
        Intent intent = new Intent(parent, FragmentHolderActivity.class);
        intent.putExtra(IngosApplication.EXTRA_FRAGMENT_CLASSNAME, fragmentClass.getName());
        parent.startActivity(intent);
    }
}
