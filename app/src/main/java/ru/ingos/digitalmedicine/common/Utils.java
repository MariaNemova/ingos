package ru.ingos.digitalmedicine.common;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Window;

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
            //FIXME перед релизхом убрать эту строку обязательно!
            throw new RuntimeException("StatusBar size not found!");
        }
        return result;
    }

}
