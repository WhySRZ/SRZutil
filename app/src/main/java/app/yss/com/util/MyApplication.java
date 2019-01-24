package app.yss.com.util;

import android.app.Application;

import app.yss.com.util.util.AppContext;

/**
 *  项目描述:
 *  作者: shenrunzhou 
 *  创建时间  :2019-01-23  10:25
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        AppContext.initContext(this);
    }
}
