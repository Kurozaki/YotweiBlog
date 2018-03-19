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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
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
