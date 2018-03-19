package com.yotwei.blog.service;

import com.yotwei.blog.dao.ArticleDAO;
import com.yotwei.blog.dao.TagDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YotWei on 2018/2/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ArticleServiceTest {

    @Autowired
    TagDAO tagDAO;

    @Autowired
    ArticleDAO articleDAO;

    @Test
    public void test() {
//        System.out.println(articleDAO.getArticleTotalInfo());
    }
}
