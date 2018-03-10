package com.yotwei.blog.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YotWei on 2018/2/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TagDaoTest {

    @Autowired
    private TagDAO tagDao;

    @Test
    public void getTagById() {
        System.out.println(tagDao.getArticleTags(1000));
    }

}