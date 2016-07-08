package com.example.gjian.base;

import android.content.Intent;
import android.os.Bundle;;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gjian.util.R;


/**
 * 基础的Activity
 * Created by Administrator on 2016/6/21 0021.
 */
public class BaseActivity extends FragmentActivity implements View.OnClickListener {

    public static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * 内容页
     */
    private FrameLayout mFltContent;
    /**
     * 标题布局
     */
    private RelativeLayout mRltTitle;
    /**
     * 标题左侧图片、中间文字和右侧文字
     */
    private ImageView mImgLeft;
    private TextView mTxtMid;
    private TextView mTxtRight;
    /**
     * 点击标题接口
     */
    private OnClickTitle mOnClickTitle;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        // 取消标题栏

        initBaseView();

    }

    private void initBaseView() {
        mFltContent = (FrameLayout) findViewById(R.id.frt_content);
        mRltTitle = (RelativeLayout) findViewById(R.id.rlt_title);
        mImgLeft = (ImageView) findViewById(R.id.img_title_left);
        mTxtMid = (TextView) findViewById(R.id.txt_title_mid);
        mTxtRight = (TextView) findViewById(R.id.txt_title_right);
        mImgLeft.setOnClickListener(this);
        mTxtMid.setOnClickListener(this);
        mTxtRight.setOnClickListener(this);
    }



    /**
     * 显示标题
     * @param left  左侧图片资源
     * @param mid   中间文字
     * @param right 右侧文字
     * @param onClickTitle  点击各个部分的监听
     */
    public void showTitle(int left,String mid,String right,OnClickTitle onClickTitle){
        mRltTitle.setVisibility(View.VISIBLE);
        mImgLeft.setImageResource(left);
        mTxtMid.setText(mid);
        mTxtRight.setText(right);
        mOnClickTitle = onClickTitle;
    }

    /**
     * 设置标题的各个部分是否可见
     * @param left
     * @param mid
     * @param right
     */
    public void setTitleBoxIsVisible(boolean left,boolean mid,boolean right){
        if (null != mImgLeft){
            mImgLeft.setVisibility(left?View.VISIBLE:View.GONE);
        }
        if (null != mTxtMid){
            mTxtMid.setVisibility(mid?View.VISIBLE:View.GONE);
        }
        if (null != mTxtRight){
            mTxtRight.setVisibility(right?View.VISIBLE:View.GONE);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_title_left:
                if (null != mOnClickTitle)
                    mOnClickTitle.onClick(ClickType.LEFT);
                break;
            case R.id.txt_title_mid:
                if (null != mOnClickTitle)
                    mOnClickTitle.onClick(ClickType.MID);
                break;
            case R.id.txt_title_right:
                if (null != mOnClickTitle)
                    mOnClickTitle.onClick(ClickType.RIGHT);
                break;
            default:
                break;
        }
    }

    /**
     * 点击标题的回调接口
     */
    public interface OnClickTitle{
        void onClick(ClickType type);
    }

    /**
     * 点击标题的枚举类型
     */
    public enum ClickType{
        LEFT,MID,RIGHT
    }

    /**
     * 设置内容布局
     */
    public void setLayoutContent(int resId){
        if (null != mFltContent){
            LayoutInflater inflater = LayoutInflater.from(this);
            View content = inflater.inflate(resId,null);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            content.setLayoutParams(params);
            mFltContent.addView(content);
        }else {
            try {
                throw new Exception("根布局为空，无法添加");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void toActivity(Class<?> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }


}
