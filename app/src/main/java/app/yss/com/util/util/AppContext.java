package app.yss.com.util.util;

import android.content.Context;

import app.yss.com.util.MyApplication;

/**
 *  项目描述:
 *  作者: shenrunzhou 
 *  创建时间  :2019-01-23  10:27
 */

public class AppContext {

   private static MyApplication mMyApplication;


   public static void initContext(MyApplication myApplication){

       if (mMyApplication==null){
           mMyApplication = myApplication;
       }else {
           throw new IllegalStateException("初始化异常 set context duplicate");
       }
   }

    public static Context getmAppContext(){

        return mMyApplication.getApplicationContext();
    }
}
