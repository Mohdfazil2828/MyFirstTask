package com.myfirsttask.SharePref;

import android.content.Context;
import android.content.SharedPreferences;


public class Utils {

    private static final String SHARED_PREF_NAME = "my_shared_pref";

    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String IS_LOGIN_API = "isLoginApi";
    private static final String IS_TOKEN = "isToken";
    private static final String IS_GROUND_LIST = "isGroundList";


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private Context context;


    private Utils() {
    }

    public static void setIsLoggedIn(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(IS_LOGGED_IN, status);
        editor.commit();
    }

    public static String getIsLoggedIn(Context context) {

        String status;

        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        status = sharedPreferences.getString(IS_LOGGED_IN, "0");

        return status;
    }


    public static void setIsToken(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(IS_TOKEN, status);
        editor.commit();
    }

    public static String getIsToken(Context context) {

        String status;

        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        status = sharedPreferences.getString(IS_TOKEN, "0");

        return status;
    }

    public static void setIsLoginApi(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(IS_LOGIN_API, status);
        editor.commit();
    }

    public static String getIsLoginApi(Context context) {

        String status;

        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        status = sharedPreferences.getString(IS_LOGIN_API, "0");

        return status;
    }

    public static void setIsGroundList(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(IS_GROUND_LIST, status);
        editor.commit();
    }

    public static String getIsGroundList(Context context) {

        String status;

        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        status = sharedPreferences.getString(IS_GROUND_LIST, "0");

        return status;
    }


}
