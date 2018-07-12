package com.yotwei.blog.dao;

import com.yotwei.blog.enity.TimelineNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by YotWei on 2018/7/12.
 */
public interface TimelineDao {

    List<TimelineNode> queryTimelineNodes(@Param("offset") int offset, @Param("length") int length);

    void insertTimelineNode(TimelineNode node);
}
