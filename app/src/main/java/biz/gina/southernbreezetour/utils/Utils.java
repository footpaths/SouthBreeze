package biz.gina.southernbreezetour.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



import java.lang.reflect.Type;
import java.util.List;

import biz.gina.southernbreezetour.SBI_App;

/**
 * @author Created by quantran on 7/5/17.
 */

public class Utils {

    public static void savePreference(String key, String value) {
        SharedPreferences.Editor editor = SBI_App.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SBI_App.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void savePreference(String key, long value) {
        SharedPreferences.Editor editor = SBI_App.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SBI_App.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLongValue(String key, int defaultValue) {
        SharedPreferences settings = SBI_App.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SBI_App.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    public static String getStringValue(String key) {
        SharedPreferences settings = SBI_App.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SBI_App.MODE_PRIVATE);
        return settings.getString(key, "");
    }



    public static boolean isNetworkConnected(Context mContext) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

/*    //region "List School Grade"
    public static void saveListSchoolGrade(List<SchoolGrade> gradeList) {
        Type listType = new TypeToken<List<SchoolGrade>>() {}.getType();
        String json = new Gson().toJson(gradeList, listType);
        SharedPreferences.Editor editor = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE).edit();
        editor.putString(Constants.PREF_LIST_SCHOOL_GRADE, json);
        editor.apply();
    }

    public static List<SchoolGrade> getListSchoolGrade() {
        SharedPreferences settings = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE);
        String json = settings.getString(Constants.PREF_LIST_SCHOOL_GRADE, "[]");
        Type listType = new TypeToken<List<SchoolGrade>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }
    //endregion

    //region "List School Year"
    public static void saveListSchoolYear(List<SchoolYear> list) {
        Type listType = new TypeToken<List<SchoolYear>>() {}.getType();
        String json = new Gson().toJson(list, listType);
        SharedPreferences.Editor editor = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE).edit();
        editor.putString(Constants.PREF_LIST_SCHOOL_YEAR, json);
        editor.apply();
    }

    public static List<SchoolYear> getListSchoolYear() {
        SharedPreferences settings = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE);
        String json = settings.getString(Constants.PREF_LIST_SCHOOL_YEAR, "[]");
        Type listType = new TypeToken<List<SchoolYear>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }
    //endregion

    public static void saveNotifyReceiveNewMessage(boolean isNotifyWhenReceiveNewMessage) {
        SharedPreferences.Editor editor = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE).edit();
        editor.putString(
                Constants.PREF_NOTIFY_RECEIVE_NEW_MESSAGE, String.valueOf(isNotifyWhenReceiveNewMessage));
        editor.apply();
    }

    public static String getNotifyReceiveNewMessage() {
        SharedPreferences settings = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE);
        return settings.getString(Constants.PREF_NOTIFY_RECEIVE_NEW_MESSAGE, String.valueOf(false));
    }

    public static void saveNotifyScheduleWasChanged(boolean isNotifyWhenScheduleWasChanged) {
        SharedPreferences.Editor editor = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE).edit();
        editor.putString(
                Constants.PREF_NOTIFY_SCHEDULE_WAS_CHANGED, String.valueOf(isNotifyWhenScheduleWasChanged));
        editor.apply();
    }

    public static String getNotifyScheduleWasChanged() {
        SharedPreferences settings = SMASApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, SMASApp.MODE_PRIVATE);
        return settings.getString(Constants.PREF_NOTIFY_SCHEDULE_WAS_CHANGED, String.valueOf(false));
    }*/


}