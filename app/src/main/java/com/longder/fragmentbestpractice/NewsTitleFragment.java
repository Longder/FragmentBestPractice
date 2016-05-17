package com.longder.fragmentbestpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻标题列表Fragment，包含一个ListView
 * Created by Longder on 2016/5/16.
 */
public class NewsTitleFragment extends Fragment {
    //Fragment中的ListView对象
    private ListView newsTitleListView;
    //新闻列表
    private List<News> newsList;
    //展现新闻的适配器
    private NewsAdapter newsAdapter;
    //标识出是单页显示还是双页显示
    private boolean isTwoPane;


    /**
     * 当Fragment被依附于容器中时调用（在onCreate之前调用）
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsList = getNews();
        newsAdapter = new NewsAdapter(context, R.layout.news_item, newsList);
        Log.d("NewsTitleFragment", "依附依附");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(newsAdapter);
        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if (isTwoPane) {
                    //如果是双页布局，就更新Fragment
                    NewsContentFragment newsContentFragment =
                            (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    newsContentFragment.refresh(news.getTitle(), news.getContent());
                } else {
                    //如果是单页布局，就启动一个新的Activity
                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                }
            }
        });
        Log.d("NewsTitleFragment", "加载新闻列表");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("NewsTitleFragment", "活动已经创建");
        //如果可以找到这个布局，就是双页布局
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            Log.d("是否找到", "找到了，不为空");
            isTwoPane = true;
        } else {
            Log.d("是否找到", "没找到，为空");
            isTwoPane = false;
        }
    }

    /**
     * 初始化新闻集合并返回
     *
     * @return
     */
    private List<News> getNews() {
        List<News> list = new ArrayList<>();
        list.add(new News("小标题", "内容内内容内内容内内容内内容内内容内内容内内容内"));
        list.add(new News("大标题", "啦啦啦啦啦啦啦啦啦啦"));
        list.add(new News("小屁孩", "揍你揍你揍你揍你揍你揍你揍你揍你揍你揍你揍你揍你"));
        return list;
    }
}
