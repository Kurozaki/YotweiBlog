package com.yotwei.blog.controller;

import com.alibaba.fastjson.JSON;
import com.yotwei.blog.dto.ResponseBean;
import com.yotwei.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YotWei on 2018/2/6.
 */

@CrossOrigin("*")
@Controller
@ResponseBody
@RequestMapping(value = "/article", produces = "text/json; charset=utf-8")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 返回全部标签
     */
    @RequestMapping("/tags/list")
    public String getTagList() {
        return ResponseBean.success(articleService.getAllTags()).toString();
    }

    /**
     * 文章预览列表
     */
    @RequestMapping("/preview/list")
    public String getArticlePreviewList(
            @RequestParam("len") int length,
            @RequestParam(value = "offset", defaultValue = "0") int offset) {
        return ResponseBean.success(articleService.getArticlePreviewList(offset, length)).toString();
    }
}
