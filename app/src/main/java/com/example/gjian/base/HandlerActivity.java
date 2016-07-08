package com.example.gjian.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/6/21 0021.
 */
public abstract class HandlerActivity extends BaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 消息提交给子类实现
     * @param msg
     */
    protected abstract void handlerMessage(Message msg);


    public Handler getHandler(){
        return handler;
    }





}
