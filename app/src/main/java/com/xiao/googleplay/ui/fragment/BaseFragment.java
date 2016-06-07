package com.xiao.googleplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiao.googleplay.ui.view.LoadingPage;
import com.xiao.googleplay.utils.UIUtils;

/**
 * Created by hasee on 2016/6/2.
 */
public abstract class BaseFragment extends Fragment {

    private LoadingPage mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*//使用textview显示当前类的类名
        TextView view = new TextView(UIUtils.getContext());
        view.setText(getClass().getSimpleName());*/

        mLoadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                //此处必须调用Basefragment的onCreateSuccessView ,否则栈溢出
                return BaseFragment.this.onCreateSuccessView();

            }

            @Override
            public ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
        return mLoadingPage;
    }

    //加载成功的布局，必须由子类来实现
    public abstract View onCreateSuccessView();

    //加载网络数据，必须由子类实现
    public abstract LoadingPage.ResultState onLoad();

    //开始加载数据
    public void loadData() {
        if (mLoadingPage != null) {
            mLoadingPage.loadData();
        }
    }
}
