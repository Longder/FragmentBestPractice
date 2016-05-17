package com.longder.fragmentbestpractice;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * 显示新闻详细内容的Activity（只在小屏幕下显示）
 * Created by Longder on 2016/5/16.
 */
public class NewsContentActivity extends AppCompatActivity {
    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        //获取intent传递过来的数据
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        //获取Fragment
        NewsContentFragment newsContentFragment
                = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);

        //调用refresh刷新数据
        newsContentFragment.refresh(newsTitle, newsContent);
    }
}
