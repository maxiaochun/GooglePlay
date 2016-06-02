package com.xiao.googleplay.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.xiao.googleplay.R;
import com.xiao.googleplay.ui.fragment.BaseFragment;
import com.xiao.googleplay.ui.fragment.FragmentFactory;
import com.xiao.googleplay.ui.view.PagerTab;
import com.xiao.googleplay.utils.UIUtils;

/**
 * 当项目和appcampat关联在一起时，必须在清单文件设置theme.appcampat主题，否则会崩溃
 */
public class MainActivity extends BaseActivity {

    private PagerTab mPagerTab;//布局对象
    private ViewPager mViewPager;//布局对象
    private MyAdapter mAdapter;//页面标题数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPagerTab = (PagerTab) findViewById(R.id.pager_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mPagerTab.setViewPager(mViewPager);//将指针和viewpager绑定在一起
    }

    /**
     * FragmentPagerAdapter是PagerAdapter 的子类，如果viewpager的页面是fragment，就继承此类
     */
    class MyAdapter extends FragmentPagerAdapter {

        private final String[] mTabNames;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);//加载页面标题数组


        }

        //返回页签标题
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        //返回当前页面位置的fragment对象
        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        //fragment数量
        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }
}
