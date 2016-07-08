package com.example.gjian.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gjian.adapter.ListAdapter;
import com.example.gjian.base.BaseActivity;
import com.example.gjian.diver.DiverItemDecorationList;
import com.example.gjian.util.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class RecycleListActivity extends BaseActivity {


    private RecyclerView mRvDemo;

    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutContent(R.layout.recycle_view);
        initTitle();
        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            mDatas.add("第"+ i + "行");
        }
    }

    private void initView() {
        mRvDemo = (RecyclerView) findViewById(R.id.rv_demo);
        mRvDemo.setLayoutManager(new LinearLayoutManager(this));
        mRvDemo.setItemAnimator(new DefaultItemAnimator());
        mRvDemo.addItemDecoration(new DiverItemDecorationList(this, DiverItemDecorationList.VERTICAL_LIST));
        ListAdapter adapter = new ListAdapter(mDatas,this);
        mRvDemo.setAdapter(adapter);
    }

    private void initTitle() {
        showTitle(R.mipmap.ic_launcher,"List",null,null);
        setTitleBoxIsVisible(false,true,false);
    }
}
