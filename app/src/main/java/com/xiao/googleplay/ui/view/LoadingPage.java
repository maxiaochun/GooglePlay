package com.xiao.googleplay.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xiao.googleplay.R;
import com.xiao.googleplay.utils.UIUtils;

/**
 * 根据当前状态来显示不同页面的自定义控件
 * <p>
 * 未加载-加载中-加载失败-数据为空-加载成功
 * <p>
 * Created by hasee on 2016/6/2.
 */

public class LoadingPage extends FrameLayout {

    private static final int STATE_LOAD_UNDO = 1;//未加载
    private static final int STATE_LOAT_LOADING = 2;//正在加载
    private static final int STATE_LOAD_ERROR = 3;//加载失败
    private static final int STATE_LOAD_EMPTY = 4;//数据为空
    private static final int STATE_LOAD_SUCCESS = 5;//加载成功

    private int mCurrentState = STATE_LOAD_UNDO;//当前状态
    private View mLoadingPage;
    private View mErrorPage;
    private View mEmptyPage;

    public LoadingPage(Context context) {
        super(context);
        initView();
    }


    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        //初始化加载中的布局
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.page_loading);
            addView(mLoadingPage);//将加载中的布局添加给当前的帧布局
        }

        //初始化加载失败布局
        if (mErrorPage == null) {
            mErrorPage = UIUtils.inflate(R.layout.page_error);
            addView(mErrorPage);
        }

        //初始化数据为空布局
        if (mEmptyPage == null) {
            mEmptyPage = UIUtils.inflate(R.layout.page_empty);
            addView(mEmptyPage);
        }
        showRightPage();
    }

    /**
     * 根据当前状态，决定显示哪个布局
     */
    private void showRightPage() {
        if (mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAT_LOADING) {
            mLoadingPage.setVisibility(View.VISIBLE);
        } else {
            mLoadingPage.setVisibility(View.GONE);
        }
        mErrorPage.setVisibility(mCurrentState == STATE_LOAD_ERROR ? View.VISIBLE : View.GONE);

        mEmptyPage.setVisibility(mCurrentState == STATE_LOAD_EMPTY ? View.VISIBLE : View.GONE);
    }
}


