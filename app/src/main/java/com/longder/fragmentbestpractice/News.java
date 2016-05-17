package com.longder.fragmentbestpractice;

/**
 * 新闻实体类
 * Created by Longder on 2016/5/16.
 */
public class News {
    //新闻标题
    private String title;
    //新闻内容
    private String content;

    public News() {

    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
