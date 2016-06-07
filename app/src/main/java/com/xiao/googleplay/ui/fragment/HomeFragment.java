package com.xiao.googleplay.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.xiao.googleplay.R;
import com.xiao.googleplay.ui.adapter.MyBaseAdapter;
import com.xiao.googleplay.ui.view.LoadingPage;
import com.xiao.googleplay.utils.UIUtils;

import java.util.ArrayList;

/**
 * 首页
 * Created by hasee on 2016/6/2.
 */
public class HomeFragment extends BaseFragment {

    private ArrayList<String> data;

    //如果加载数据成功，就回调此方法，在主线程运行
    @Override
    public View onCreateSuccessView() {
//        TextView view = new TextView(UIUtils.getContext());
//        view.setText(getClass().getSimpleName());
        ListView view = new ListView(UIUtils.getContext());

        view.setAdapter(new HomeAdapter(data));
        return view;
    }

    //运行在子线程，可以直接执行耗时网络操作
    @Override
    public LoadingPage.ResultState onLoad() {

        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("测试数据：" + i);
        }
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    class HomeAdapter extends MyBaseAdapter<String>{

        public HomeAdapter(ArrayList<String> data) {
            super(data);
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null){
                convertView = UIUtils.inflate(R.layout.list_item_home);
                holder = new ViewHolder();

                holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            String content = getItem(i);
            holder.tvContent.setText(content);

            return convertView;
        }
    }
    static class ViewHolder{
        public TextView tvContent;
    }
}
