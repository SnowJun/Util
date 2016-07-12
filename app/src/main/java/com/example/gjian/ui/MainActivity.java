package com.example.gjian.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.gjian.base.BaseActivity;
import com.example.gjian.util.R;
import com.example.gjian.util.ToastUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTxtNormal;
    private TextView mTxtNormalCenter;
    private TextView mTxtImg;
    private TextView mTxtImgCenter;
    private TextView mTxtCancel;
    private TextView mTxtNext;
    private TextView mTxtSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutContent(R.layout.activity_main);
        initTitle();
        initView();
    }

    private void initTitle() {
        showTitle(R.mipmap.ic_launcher,"主页",null,null);
        setTitleBoxIsVisible(false,true,false);
    }

    private void initView() {
        mTxtNormal = (TextView) findViewById(R.id.txt_normal);
        mTxtNormalCenter = (TextView) findViewById(R.id.txt_normal_center);
        mTxtImg = (TextView) findViewById(R.id.txt_img);
        mTxtImgCenter = (TextView) findViewById(R.id.txt_img_center);
        mTxtCancel = (TextView) findViewById(R.id.txt_cancel);
        mTxtNext = (TextView) findViewById(R.id.txt_next);
        mTxtSnack = (TextView) findViewById(R.id.txt_snack);
        mTxtNormal.setOnClickListener(this);
        mTxtNormalCenter.setOnClickListener(this);
        mTxtImg.setOnClickListener(this);
        mTxtImgCenter.setOnClickListener(this);
        mTxtCancel.setOnClickListener(this);
        mTxtNext.setOnClickListener(this);
        mTxtSnack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_normal:
                ToastUtils.getInstance(getApplicationContext()).showToast("normal toast",false);
                break;
            case R.id.txt_normal_center:
                ToastUtils.getInstance(getApplicationContext()).showToast("normal center toast",false, Gravity.CENTER);
                break;
            case R.id.txt_img:
                ToastUtils.getInstance(getApplicationContext()).showToastWithImage("image toast",false,R.mipmap.ic_launcher);
                break;
            case R.id.txt_img_center:
                ToastUtils.getInstance(getApplicationContext()).showToastWithImage("image center toast",false,R.mipmap.ic_launcher,Gravity.CENTER);
                break;
            case R.id.txt_snack:
                showSnackBar();
                break;
            case R.id.txt_cancel:
                ToastUtils.getInstance(this).cancelToast();
                break;
            case R.id.txt_next:
               toActivity(NextActivity.class);
                break;
            default:
                break;
        }
    }

    private void showSnackBar() {
        final Snackbar snackbar = Snackbar.make(mTxtSnack,"SnackBar",Snackbar.LENGTH_LONG);
        snackbar.setAction("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.getView().setBackgroundColor(Color.GREEN);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.getInstance(this).cancelToast();
    }
}
