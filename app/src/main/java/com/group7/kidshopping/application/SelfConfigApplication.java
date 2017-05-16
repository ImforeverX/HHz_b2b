package com.group7.kidshopping.application;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by lining on 2017/5/16.
 */
public class SelfConfigApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        AutoLayoutConifg.getInstance().useDeviceSize();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
