package com.yotwei.blog.enity;


/**
 * Created by YotWei on 2018/2/13.
 */
public class Article{

    private int id;
    private String title;
    private String coverUrl;
    private String intro;
    private String content;
    private long createTime;
    private int articleType;
    private int readCount;
    private int commentFloorCount;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
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

    public int getCommentFloorCount() {
        return commentFloorCount;
    }

    public void setCommentFloorCount(int commentFloorCount) {
        this.commentFloorCount = commentFloorCount;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", articleType=" + articleType +
                ", readCount=" + readCount +
                ", commentFloorCount=" + commentFloorCount +
                '}';
    }
}
