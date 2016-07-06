package com.example.gjian.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2016/6/21.
 */
public class NextActivity extends Activity {

    private RecyclerView mRvDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        ToastUtils.getInstance(getApplicationContext()).showToast("next page",false);
    }
}
