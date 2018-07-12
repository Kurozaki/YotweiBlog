package com.yotwei.blog.enity;

/**
 * Created by YotWei on 2018/7/10.
 */
public class ArticleContent {

    private int articleId;
    private String content;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id=" + articleId +
                ", content='" + content + '\'' +
                '}';
    }
}
