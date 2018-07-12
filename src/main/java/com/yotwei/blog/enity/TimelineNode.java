package com.yotwei.blog.enity;

/**
 * Created by YotWei on 2018/7/12.
 */
public class TimelineNode {

    private int id;
    private String createTime;
    private String content;
    private String assocUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAssocUrl() {
        return assocUrl;
    }

    public void setAssocUrl(String assocUrl) {
        this.assocUrl = assocUrl;
    }

    @Override
    public String toString() {
        return "TimelineNode{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", assocUrl='" + assocUrl + '\'' +
                '}';
    }
}
