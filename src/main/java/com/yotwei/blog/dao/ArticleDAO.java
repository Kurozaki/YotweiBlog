package com.yotwei.blog.dao;

import com.yotwei.blog.enity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by YotWei on 2018/2/13.
 */
public interface ArticleDAO {

    List<Article> getArticlePreviewList(@Param("offset") int offset, @Param("length") int length);
}
