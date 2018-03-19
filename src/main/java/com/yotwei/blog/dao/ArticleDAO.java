package com.yotwei.blog.dao;

import com.yotwei.blog.dto.ArticleRecommend;
import com.yotwei.blog.enity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by YotWei on 2018/2/13.
 */
public interface ArticleDAO {

    List<Article> getArticlePreviewList(@Param("offset") int offset, @Param("length") int length);

    List<Article> getArticlePreviewListByTagId(
            @Param("offset") int offset, @Param("length") int length, @Param("tagId") int tagId);

    List<ArticleRecommend> getArticleRecommendList();

    Article getArticleById(int articleId);

    List<Map<String, String>> admGetArticleList();

    Map<String, String> getArticleStatisInfo();
}
