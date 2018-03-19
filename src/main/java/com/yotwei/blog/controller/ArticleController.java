package com.yotwei.blog.controller;

import com.yotwei.blog.dto.ArticleDetail;
import com.yotwei.blog.dto.ResponseBean;
import com.yotwei.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * [文章模块] 返回全部标签
     */
    @RequestMapping("/tags/list")
    public String getTagList() {
        return ResponseBean.success(articleService.getAllTags()).toString();
    }

    /**
     * [首页/文章模块] 文章预览列表
     */
    @RequestMapping("/preview/list")
    public String getArticlePreviewList(
            @RequestParam("len") int length,
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "tag_id", defaultValue = "-1") int tagId) {
        return ResponseBean.success(articleService.getArticlePreviewList(offset, length, tagId)).toString();
    }

    /**
     * [文章模块] 文章详情
     */
    @RequestMapping("/detail/{articleId}")
    public String getArticleDetail(@PathVariable("articleId") int articleId) {
        ArticleDetail detail = articleService.getArticleDetailById(articleId);
        if (detail == null) {
            return ResponseBean.error("No such article.").toString();
        }
        return ResponseBean.success(detail).toString();
    }

    /**
     * [文章模块] 文章推荐列表
     */
    @RequestMapping("/recommend/list")
    public String getArticleRecommendList() {
        return ResponseBean.success(articleService.getArticleRecommendList()).toString();
    }

    /**
     * [首页] 显示文章总数和阅读总数
     */
    @RequestMapping("/statis")
    public String getArticleStatisInfo() {
        return ResponseBean.success(articleService.getArticleStatisInfo()).toString();
    }
}
