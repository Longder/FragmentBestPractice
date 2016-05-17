package com.longder.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 显示新闻内容的Fragment（大屏幕显示在右边，小屏幕直接显示在跳转后的Activity中）
 * Created by Longder on 2016/5/16.
 */
public class NewsContentFragment extends Fragment {
    //存储View
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityView = view.findViewById(R.id.visibility_layout);
        visibilityView.setVisibility(View.VISIBLE);
        TextView titleText = (TextView) visibilityView.findViewById(R.id.news_title);
        TextView contentText = (TextView) visibilityView.findViewById(R.id.news_content);
        titleText.setText(newsTitle);
        contentText.setText(newsContent);
    }
}
