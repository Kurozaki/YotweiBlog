package com.yotwei.blog.service;

import com.yotwei.blog.dao.TimelineDao;
import com.yotwei.blog.enity.TimelineNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YotWei on 2018/7/12.
 */
@Service
public class TimelineService {

    private static final int PAGING_COUNT = 5;

    private final TimelineDao timelineDao;

    @Autowired
    public TimelineService(TimelineDao timelineDao) {
        this.timelineDao = timelineDao;
    }

    public List<TimelineNode> getTimelineNodes(int offset) {
        return timelineDao.queryTimelineNodes(offset, PAGING_COUNT);
    }

    public void addTimelineNode(String content, String assocUrl) {
        TimelineNode node = new TimelineNode();
        node.setContent(content);
        node.setAssocUrl(assocUrl);
        timelineDao.insertTimelineNode(node);
    }
}
