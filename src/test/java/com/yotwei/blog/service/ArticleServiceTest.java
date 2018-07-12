package com.yotwei.blog.service;

import com.yotwei.blog.dao.TagDao;
import com.yotwei.blog.enity.ArticleContent;
import com.yotwei.blog.enity.ArticlePreview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YotWei on 2018/6/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ArticleServiceTest {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ArticleService articleService;

    @Test
    public void getArticlePreviewList() {

        ArticlePreview pv = new ArticlePreview();
        ArticleContent ct = new ArticleContent();

        System.out.println(articleService.addArticle(pv, ct));
    }
}

