package ru.ingos.digitalmedicine.common;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.ui.activities.MainActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

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
        int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }else {
            //FIXME не ронять приложение. найти выход из ситуации
            throw new RuntimeException("StatusBar size not found!");
        }
        return result;
    }

    public static int getActionBarHeight(Resources resources, Resources.Theme theme){
        TypedValue tv = new TypedValue();
        if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            return TypedValue.complexToDimensionPixelSize(tv.data,resources.getDisplayMetrics());
        }else {
            //FIXME не ронять приложение. найти выход из ситуации
            throw new RuntimeException("ActionBar not found!");
        }
    }

    public static int getWindowHeight(WindowManager manager){
        Point p = new Point();
        manager.getDefaultDisplay().getSize(p);
        return p.y;
    }

    public static void setActivityTitle(int pointer, Activity activity){
        if(activity instanceof MainActivity){
            ((MainActivity) activity).getSupportActionBar().setTitle(pointer);
        }
    }

    public static void changerMainActivityFragment(Class<? extends MvpFragment> fragClass, Activity activity){
        if(activity instanceof MainActivity){
            ((MainActivity) activity).bindFragment(fragClass, true);
        }

    }
}
