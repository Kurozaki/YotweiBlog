package com.yotwei.blog.service;

import com.yotwei.blog.dao.ArticleDao;
import com.yotwei.blog.enity.ArticleContent;
import com.yotwei.blog.enity.ArticlePreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by YotWei on 2018/6/27.
 */
@Service
public class ArticleService {

    private static final int PAGE_ITEM_COUNT = 5;

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<ArticlePreview> getArticlePreviewList(int page) {
        return articleDao.queryArticlePreviewList(page * PAGE_ITEM_COUNT, PAGE_ITEM_COUNT);
    }

    private Map<String, Integer> statCacheMap;

    public Map<String, Integer> getStatisticsInfo() {
        if (statCacheMap == null)
            statCacheMap = new HashMap<>();

        // query rows count from database
        int totalCount = articleDao.queryTotalCount();
        int pageCount = totalCount / PAGE_ITEM_COUNT;

        if (pageCount * PAGE_ITEM_COUNT < totalCount)
            pageCount++;

        statCacheMap.put("articleCount", totalCount);
        statCacheMap.put("pageCount", pageCount);

        return statCacheMap;
    }

    public Map<String, Object> getArticleDetail(int articleId) {
        // query data
        Map<String, Object> map = new HashMap<>();
        map.put("preview", articleDao.queryArticlePreviewById(articleId));
        map.put("content", articleDao.queryArticleContentById(articleId));
        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addArticle(ArticlePreview preview, ArticleContent content) {
        articleDao.insertArticlePreview(preview);
        content.setArticleId(preview.getId());
        articleDao.insertArticleContent(content);
        return preview.getId();
    }

    public List<String> getArticleCatalogs() {
        return articleDao.queryArticleCatalogs();
    }

    public void incReadCount(int articleId) {
        articleDao.incArticleReadCount(articleId, 1);
    }
}
