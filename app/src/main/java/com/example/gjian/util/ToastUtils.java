package com.example.gjian.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;

/**
 * V 1.0
 * Toast  工具封装
 * 显示文字Toast、图片Toast 可自定义位置
 * Created by Administrator on 2016/6/21.
 */
public class ToastUtils {

    private static final String TAG = ToastUtils.class.getSimpleName();

    private static ToastUtils ourInstance;
    /**
     * 我的Toast对象
     */
    private Toast mToast;

    private Object synObj = new Object();

    private Handler handler = new Handler(Looper.getMainLooper());

    private Context mContext;
    /**
     *IMAGE TOAST show
     */
    private ImageView mImgToast;

    public static ToastUtils getInstance(Context context) {
        if (null == ourInstance) {
            ourInstance = new ToastUtils(context);
        }
        return ourInstance;
    }

    private ToastUtils(Context context) {
        mContext = context;
        mImgToast = new ImageView(context);
    }

    /**
     * start V1.0
     * 显示Toast
     *
     * @param content 显示的内容
     * @param isLong  是否是长时间显示
     */
    public void showToast(final String content, final boolean isLong) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (null == mToast) {
                        mToast = Toast.makeText(mContext, content, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.show();
                    } else {
                        //先toast显示的取消
//                        mToast.cancel();
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mToast.setText(content);
                        mToast.setGravity(Gravity.BOTTOM,0,0);
                        mToast.setDuration(isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.show();

                    }
                }
            }
        });

    }

    /**
     * start V1.0
     * 显示Toast
     *
     * @param content 内容
     * @param isLong  是否是长时间显示
     * @param gravity 显示的位置
     */
    public void showToast(final String content, final boolean isLong, final int gravity) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (null == mToast) {
                        mToast = Toast.makeText(mContext, content, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.setGravity(gravity, 0, 0);
                        mToast.show();
                    } else {
                        //先进项toast显示的取消
//                        mToast.cancel();
                        mToast.setText(content);
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mToast.setGravity(gravity, 0, 0);
                        mToast.setDuration(isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                }
            }
        });


    }

    /**
     * start V1.0
     * 带图片的Toast
     *
     * @param content 内容
     * @param isLong  是否长显示
     * @param resId   图片资源ID
     */
    public void showToastWithImage(final String content, final boolean isLong, final int resId) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (null == mToast) {
                        mToast = Toast.makeText(mContext, content, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mImgToast.setImageResource(resId);
                        toastView.addView(mImgToast,0);
                        mToast.show();
                    } else {
//                        mToast.cancel();
                        mToast.setText(content);
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mImgToast.setImageResource(resId);
                        toastView.addView(mImgToast,0);
                        mToast.setGravity(Gravity.BOTTOM,0,0);
                        mToast.setDuration(isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                }
            }
        });

    }

    /**
     * start V1.0
     *
     * @param content 显示内容
     * @param isLong  是否长显示
     * @param resId   图片资源ID
     * @param gravity toast位置
     */
    public void showToastWithImage(final String content, final boolean isLong, final int resId, final int gravity) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (null == mToast) {
                        mToast = Toast.makeText(mContext, content, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mImgToast.setImageResource(resId);
                        toastView.addView(mImgToast);
                        mToast.setGravity(gravity, 0, 0);
                        mToast.show();
                    } else {
//                        mToast.cancel();
                        mToast.setText(content);
                        LinearLayout toastView = (LinearLayout) mToast.getView();
                        toastView.removeView(mImgToast);
                        mImgToast.setImageResource(resId);
                        toastView.addView(mImgToast,0);
                        mToast.setDuration(isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                        mToast.setGravity(gravity, 0, 0);
                        mToast.show();
                    }
                }
            }
        });

    }

    /**
     * 取消Toast显示
     */
    public void cancelToast() {
        if (null != mToast) {
            mToast.cancel();
        }
    }


}
