package com.vppank.cricketadventure.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.vppank.cricketadventure.service.backgroundservices.MessingService;
import com.vppank.cricketadventure.storage.PrefManager;

public class CricketApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CricketApplication.context = this;
        this.startService(new Intent(this, MessingService.class));
    }

    public static PrefManager getPrefManager() {
        return PrefManager.getInstance(CricketApplication.context);
    }
}
