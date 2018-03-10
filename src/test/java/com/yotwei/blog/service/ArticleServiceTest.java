package com.yotwei.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by YotWei on 2018/2/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ArticleServiceTest {

    @Autowired
    ArticleService service;

    @Test
    public void getArticleDetail() {

//        System.out.println(service.getArticleDetail(1000));
//        System.out.println(service.getArticlePreviewList());
    }
}