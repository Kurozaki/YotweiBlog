package com.yotwei.blog.dao;

import com.yotwei.blog.enity.TimelineNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by YotWei on 2018/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")

public class TimelineDaoTest {

    @Autowired
    private TimelineDao dao;

    @Test
    public void queryTimelineNodes() {
        System.out.println(dao.queryTimelineNodes(1, 5));
    }

    @Test
    public void insertTimelineNode() {
        TimelineNode node = new TimelineNode();
        node.setContent("手机端页面也完成了！");
        dao.insertTimelineNode(node);
    }
}