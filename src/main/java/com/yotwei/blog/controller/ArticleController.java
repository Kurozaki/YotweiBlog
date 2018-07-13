package com.yotwei.blog.controller;

import com.yotwei.blog.enity.ArticleCatalog;
import com.yotwei.blog.enity.ArticleContent;
import com.yotwei.blog.enity.ArticlePreview;
import com.yotwei.blog.enity.ResponseBean;
import com.yotwei.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by YotWei on 2018/6/27.
 */
@Controller
@RequestMapping("/article")
@ResponseBody
@CrossOrigin("*")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/catalogs")
    public List<String> getArticleCatalogs() {
        return articleService.getArticleCatalogs();
    }

    @RequestMapping("/previewlist")
    public List<ArticlePreview> getArticlePreviewList(
            @RequestParam(value = "page", defaultValue = "0") int page) {
        return articleService.getArticlePreviewList(page);
    }

    @RequestMapping("/detail")
    public Map<String, Object> getArticleContent(
            @RequestParam("articleId") int articleId) {
        return articleService.getArticleDetail(articleId);
    }

    @RequestMapping("/statistics")
    public Map<String, Integer> statistics() {
        return articleService.getStatisticsInfo();
    }

    /*
     * for admin
     */
    @RequestMapping("/add")
    public ResponseBean addArticle(@RequestParam("title") String title,
                                   @RequestParam("intro") String intro,
                                   @RequestParam("content") String content) {

        ArticlePreview pv = new ArticlePreview();
        pv.setTitle(title);
        pv.setIntro(intro);

        ArticleContent cnt = new ArticleContent();
        cnt.setContent(content);
        try {
            articleService.addArticle(pv, cnt);
            return ResponseBean.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBean.error(null);
    }
}
