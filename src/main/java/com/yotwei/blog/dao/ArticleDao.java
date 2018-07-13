package com.yotwei.blog.dao;

import com.yotwei.blog.enity.ArticleContent;
import com.yotwei.blog.enity.ArticlePreview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by YotWei on 2018/7/7.
 */
public interface ArticleDao {

    List<String> queryArticleCatalogs();

    List<ArticlePreview> queryArticlePreviewList(@Param("offset") int offset, @Param("length") int length);

    ArticlePreview queryArticlePreviewById(@Param("articleId") int articleId);

    ArticleContent queryArticleContentById(@Param("articleId") int articleId);

    void insertArticlePreview(ArticlePreview preview);

    void insertArticleContent(ArticleContent content);

    int queryTotalCount();
}
