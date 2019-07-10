package com.myfirsttask.SharePref;

import android.content.Context;
import android.content.SharedPreferences;

import com.myfirsttask.Model.User;


public class Utils {

    public static final String SHARED_PREF_NAME = "my_shared_pref";

    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String IS_SAVE_USER = "isSaveUser";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private Context context;


    public Utils(Context context) {
        this.context = context;

    }

    public static void setIsSaveUser(Context context, User user) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getName());
        editor.putInt("mobile", user.getMobile());

        editor.commit();
    }

    public static String getIsSaveUser(Context context) {

        String user;

        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        user = sharedPreferences.getString(IS_SAVE_USER, "0");

        return user;
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

    public User getUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("name", null),
                sharedPreferences.getInt("mobile", 0)
        );
    }
}
