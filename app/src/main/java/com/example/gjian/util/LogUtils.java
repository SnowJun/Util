package com.example.gjian.util;

import android.util.Log;

/**
 * Log的工具类，Log管理
 * 根据级别关闭，调试模式关闭
 * Created by Administrator on 2016/7/4 0004.
 */
public class LogUtils {

    /**
     * 调试模式
     */
    private static final boolean DEBUG = true;
    /**
     * Log级别
    * 默认为最低级别，即全部打印
    */
    private int logLevel = Log.ERROR;

    private static LogUtils ourInstance;
    public static LogUtils getInstance() {
        if (null == ourInstance){
            ourInstance = new LogUtils();
        }
        return ourInstance;
    }

    private LogUtils() {
    }

    /**
     * V1.0
     * 打印V级别Log
     * @param tag Log的TAG值
     * @param log Log内容
     */
    public void v(String tag,String log){
        if (DEBUG && (logLevel >= Log.VERBOSE)){
            Log.v(tag,"log_util_v:"+log);
        }
    }

    /**
     * V1.0
     * 打印D级别Log
     * @param tag Log的TAG值
     * @param log Log内容
     */
    public void d(String tag,String log){
        if (DEBUG && (logLevel >= Log.DEBUG)){
            Log.d(tag,"log_util_v:"+log);
        }
    }

    /**
     * V1.0
     * 打印I级别Log
     * @param tag Log的TAG值
     * @param log Log内容
     */
    public void i(String tag,String log){
        if (DEBUG && (logLevel >= Log.INFO)){
            Log.i(tag,"log_util_v:"+log);
        }
    }

    /**
     * V1.0
     * 打印W级别Log
     * @param tag Log的TAG值
     * @param log Log内容
     */
    public void w(String tag,String log){
        if (DEBUG && (logLevel >= Log.WARN)){
            Log.w(tag,"log_util_v:"+log);
        }
    }

    /**
     * V1.0
     * 打印E级别Log
     * @param tag Log的TAG值
     * @param log Log内容
     */
    public void e(String tag,String log){
        if (DEBUG && (logLevel >= Log.ERROR)){
            Log.e(tag,"log_util_v:"+log);
        }
    }


    /**
     * 设置Log的打印级别
     * @param level Log的打印级别
     * 取值为Log.VERBOSE到Log.ERROR
     */
    public void setLogLevel(int level){
       logLevel = level;
    }


}
