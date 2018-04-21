package com.vppank.cricketadventure.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vppank.cricketadventure.service.api.model.User;


/**
 * Created by QUYLE on 1/14/18.
 */

public class PrefManager {

    private static PrefManager sIntance;
    private SharedPreferences mPreference;

    private PrefManager(Context context) {
        mPreference = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PrefManager getInstance(Context context) {
        if (sIntance == null) {
            sIntance = new PrefManager(context);
        }

        return sIntance;
    }

    public void setString(String key, String value) {
        mPreference.edit().putString(key, value).commit();
    }

    public String getString(String key) {
        return mPreference.getString(key, "");
    }

    public void setInt(String key, int value) {
        mPreference.edit().putInt(key, value).commit();
    }

    public int getInt(String key) {
        return mPreference.getInt(key, 0);
    }

    public void setBoolean(String key, boolean value) {
        mPreference.edit().putBoolean(key, value).commit();
    }


//    public void setListALarm(List<String> list) {
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        setString(PrefConstans.EXTRA_ARTICLES_ALARM, json);
//    }
//
//    public List<String> getListAlarm() {
//        Type listType = new TypeToken<ArrayList<String>>() {
//        }.getType();
//        List<String> list = new Gson().fromJson(getString(PrefConstans.EXTRA_ARTICLES_ALARM), listType);
//        return list;
//    }


    public void saveAuth(String auth) {
        setString(PrefConstans.EXTRA_AUTH, auth);
    }


    public String getAuth() {
        return getString(PrefConstans.EXTRA_AUTH);
    }


    public void saveUser(User user) {
        if (user != null) {
            Gson gson = new GsonBuilder().create();
            String data = gson.toJson(user, User.class);
            setString(PrefConstans.EXTRA_USER, data);
        }
    }

    public User getUser() {
        String modalString = getString(PrefConstans.EXTRA_USER);
        if (!TextUtils.isEmpty(modalString)) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(modalString, User.class);
        }
        return null;
    }

    public void clearPreferences() {
        mPreference.edit().clear().commit();
    }


}
