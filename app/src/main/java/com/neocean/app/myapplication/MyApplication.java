package com.neocean.app.myapplication;

import android.app.Application;

import com.neocean.app.logutils.LogUtils;

/**
 * User weixn
 * Date 2019/6/6
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.init(true);
    }
}
