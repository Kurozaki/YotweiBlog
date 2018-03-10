package com.yotwei.blog.dto;

import com.yotwei.blog.enity.Article;
import com.yotwei.blog.enity.Tag;

import java.util.List;

/**
 * Created by YotWei on 2018/2/13.
 */
public class ArticleDetail {

    private Article article;
    private List<Tag> tags;


    public ArticleDetail(Article article, List<Tag> tags) {
        this.article = article;
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "ArticleDetail{" +
                "article=" + article +
                ", tags=" + tags +
                '}';
    }
}
