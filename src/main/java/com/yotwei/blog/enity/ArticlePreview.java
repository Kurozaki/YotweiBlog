package com.yotwei.blog.enity;

import java.sql.Timestamp;

/**
 * Created by YotWei on 2018/7/7.
 */
public class ArticlePreview {
    private int id;
    private String title;
    private String intro;
    private Timestamp createTime;
    private int articleType;
    private int readCount;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "ArticlePreview{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", createTime=" + createTime +
                ", articleType=" + articleType +
                ", readCount=" + readCount +
                '}';
    }
}
