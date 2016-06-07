package com.xiao.googleplay.ui.fragment;

import android.view.View;

import com.xiao.googleplay.ui.view.LoadingPage;

/**
 * Created by hasee on 2016/6/2.
 */
public class AppFragment extends BaseFragment {
    //只有成功才调用此方法
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_ERROR;
    }
}
