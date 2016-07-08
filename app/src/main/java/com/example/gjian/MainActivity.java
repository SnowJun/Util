package com.example.gjian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.gjian.util.R;
import com.example.gjian.util.ToastUtils;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTxtNormal;
    private TextView mTxtNormalCenter;
    private TextView mTxtImg;
    private TextView mTxtImgCenter;
    private TextView mTxtCancel;
    private TextView mTxtNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTxtNormal = (TextView) findViewById(R.id.txt_normal);
        mTxtNormalCenter = (TextView) findViewById(R.id.txt_normal_center);
        mTxtImg = (TextView) findViewById(R.id.txt_img);
        mTxtImgCenter = (TextView) findViewById(R.id.txt_img_center);
        mTxtCancel = (TextView) findViewById(R.id.txt_cancel);
        mTxtNext = (TextView) findViewById(R.id.txt_next);
        mTxtNormal.setOnClickListener(this);
        mTxtNormalCenter.setOnClickListener(this);
        mTxtImg.setOnClickListener(this);
        mTxtImgCenter.setOnClickListener(this);
        mTxtCancel.setOnClickListener(this);
        mTxtNext.setOnClickListener(this);
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
            case R.id.txt_cancel:
                ToastUtils.getInstance(this).cancelToast();
                break;
            case R.id.txt_next:
                Intent intent = new Intent(this,NextActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.getInstance(this).cancelToast();
    }
}
