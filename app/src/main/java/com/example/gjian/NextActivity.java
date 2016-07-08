package com.example.gjian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gjian.util.R;
import com.example.gjian.util.ToastUtils;

/**
 * Created by Administrator on 2016/6/21.
 */
public class NextActivity extends Activity implements View.OnClickListener {


    private TextView mTxtList;
    private TextView mTxtGrid;
    private TextView mTxtPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ToastUtils.getInstance(getApplicationContext()).showToast("next page",false);
        initView();
    }

    private void initView() {
        mTxtList = (TextView) findViewById(R.id.txt_list);
        mTxtGrid = (TextView) findViewById(R.id.txt_grid);
        mTxtPull = (TextView) findViewById(R.id.txt_pull);
        mTxtList.setOnClickListener(this);
        mTxtGrid.setOnClickListener(this);
        mTxtPull.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_list:
                break;
            case R.id.txt_grid:
                break;
            case R.id.txt_pull:
                break;
        }
    }
}
