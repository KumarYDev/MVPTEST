package com.usermindarchive.h.mvptest;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by HERO on 9/27/2017.
 */

public class MVPApplication extends Application {

    public static MVPApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static MVPApplication getInstance() {
        return instance;
    }

}
