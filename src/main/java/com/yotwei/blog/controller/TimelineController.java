package com.yotwei.blog.controller;

import com.yotwei.blog.enity.ResponseBean;
import com.yotwei.blog.enity.TimelineNode;
import com.yotwei.blog.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YotWei on 2018/7/12.
 */

@Controller
@RequestMapping("/timeline")
@CrossOrigin("*")
@ResponseBody
public class TimelineController {

    private final TimelineService timelineService;

    @Autowired
    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @RequestMapping("/nodes")
    public List<TimelineNode> getTimelineNodes(@RequestParam("offset") int offset) {
        return timelineService.getTimelineNodes(offset);
    }

    /*
     * for admin
     */
    @RequestMapping("/addnode")
    public ResponseBean addTimelineNode(@RequestParam("content") String content,
                                        @RequestParam("assocUrl") String url) {
        try {
            timelineService.addTimelineNode(content, url);
            return ResponseBean.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBean.error(null);
    }

}
