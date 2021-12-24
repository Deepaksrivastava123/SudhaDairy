package com.example.sudhadairy.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {

    private static final String SHARED_PREF_NAME = SharedPrefUtils.class.getName();
    private SharedPreferences preferences = null;

    private static SharedPrefUtils instance = null;

    private SharedPrefUtils(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefUtils(context);
        }
        return instance;
    }

    public  void saveAdminEmail(String key, String email) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, email);
        editor.apply();
    }

    public String getAdminEmail(String key,String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public  void saveAdminPassword(String key, String password) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, password);
        editor.apply();
    }

    public String getAdminPassword(String key,String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

}
