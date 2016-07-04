package com.example.gjian.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class LogUtils {

    private static final boolean DEBUG = true;


    private static LogUtils ourInstance;
    public static LogUtils getInstance() {
        if (null == ourInstance){
            ourInstance = new LogUtils();
        }
        return ourInstance;
    }

    private LogUtils() {
    }

    public void setIsLogVerbose(){

    }

    public void setIsLogDebug(){

    }

    public void setIsLogInfo(){

    }

    public void setIsLogWarn(){

    }

    public void setIsLogError(){

    }


    public boolean isShowLog(int level){
        return true;
    }


}
