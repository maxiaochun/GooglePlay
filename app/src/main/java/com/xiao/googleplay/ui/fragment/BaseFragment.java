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
public class BaseFragment extends Fragment{

    private LoadingPage mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*//使用textview显示当前类的类名
        TextView view = new TextView(UIUtils.getContext());
        view.setText(getClass().getSimpleName());*/

        mLoadingPage = new LoadingPage(UIUtils.getContext());
        return mLoadingPage;

    }
}
