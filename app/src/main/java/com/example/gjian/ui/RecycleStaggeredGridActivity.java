package com.example.gjian.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.gjian.adapter.GridAdapter;
import com.example.gjian.adapter.StaggeredGridAdapter;
import com.example.gjian.base.BaseActivity;
import com.example.gjian.diver.DiverItemDecorationGrid;
import com.example.gjian.util.LogUtils;
import com.example.gjian.util.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class RecycleStaggeredGridActivity extends BaseActivity {

    private static final String TAG = RecycleStaggeredGridActivity.class.getSimpleName();

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
            mDatas.add("第"+ i + "个");
        }
    }

    private void initView() {
        mRvDemo = (RecyclerView) findViewById(R.id.rv_demo);
        mRvDemo.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));
        mRvDemo.setItemAnimator(new DefaultItemAnimator());
//        mRvDemo.addItemDecoration(new DiverItemDecorationGrid(this));
        StaggeredGridAdapter adapter = new StaggeredGridAdapter(mDatas,this);
        mRvDemo.setAdapter(adapter);
    }

    private void initTitle() {
        showTitle(R.mipmap.ic_launcher,"Stagger",null,null);
        setTitleBoxIsVisible(false,true,false);
    }
}
