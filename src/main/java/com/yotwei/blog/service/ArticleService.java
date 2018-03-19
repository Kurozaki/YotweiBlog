package com.yotwei.blog.service;

import com.yotwei.blog.dao.ArticleDAO;
import com.yotwei.blog.dao.TagDAO;
import com.yotwei.blog.dto.ArticleDetail;
import com.yotwei.blog.dto.ArticleRecommend;
import com.yotwei.blog.enity.Article;
import com.yotwei.blog.enity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by YotWei on 2018/2/13.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private TagDAO tagDAO;

    public List<Tag> getAllTags() {
        return tagDAO.getAllTags();
    }

    public List<Article> getArticlePreviewList(int offset, int len, int tagId) {
        if (tagId == -1) {
            return articleDAO.getArticlePreviewList(offset, len);
        } else {
            return articleDAO.getArticlePreviewListByTagId(offset, len, tagId);
        }
    }

    public List<ArticleRecommend> getArticleRecommendList() {
        return articleDAO.getArticleRecommendList();
    }

    public ArticleDetail getArticleDetailById(int articleId) {
        ArticleDetail detail;

        //query article from database
        Article articleInfo = articleDAO.getArticleById(articleId);
        if (articleInfo == null) {
            return null;
        }
        //query article's tags from database
        List<Tag> tags = tagDAO.getArticleTags(articleId);

        detail = new ArticleDetail();
        detail.setArticle(articleInfo);
        detail.setTags(tags);
        return detail;
    }

    public Map<String, String> getArticleStatisInfo() {
        return articleDAO.getArticleStatisInfo();
    }
}
