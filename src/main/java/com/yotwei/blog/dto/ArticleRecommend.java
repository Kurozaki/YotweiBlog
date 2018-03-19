package com.yotwei.blog.dto;

/**
 * Created by YotWei on 2018/3/11.
 */
public class ArticleRecommend {
    private int id;
    private String title;
    private String coverUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
