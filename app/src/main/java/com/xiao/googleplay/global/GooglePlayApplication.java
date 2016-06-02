package com.xiao.googleplay.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * 自定义application，进行全局初始化
 * Created by hasee on 2016/6/2.
 */
public class GooglePlayApplication extends Application {

    private static Context context;
    private static Handler handler;


    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        //当前线程id，此处是主线程id
        mainThreadId = Process.myTid();
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }
}
