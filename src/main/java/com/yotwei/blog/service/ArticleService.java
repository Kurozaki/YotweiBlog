package com.yotwei.blog.service;

import com.yotwei.blog.dao.ArticleDAO;
import com.yotwei.blog.dao.TagDAO;
import com.yotwei.blog.dto.ArticleDetail;
import com.yotwei.blog.enity.Article;
import com.yotwei.blog.enity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Article> getArticlePreviewList(int offset, int len) {
        return articleDAO.getArticlePreviewList(offset, len);
    }
}
