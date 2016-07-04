package com.example.gjian.util;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/21.
 */
public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToastUtils.getInstance(getApplicationContext()).showToast("next page",false);
    }
}
