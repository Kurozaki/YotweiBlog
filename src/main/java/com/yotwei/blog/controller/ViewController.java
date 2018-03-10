package com.yotwei.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YotWei on 2018/2/7.
 */
@Controller
@RequestMapping(value = "/view", method = RequestMethod.GET)
public class ViewController {

    @RequestMapping("/home")
    public String viewHome() {
        return "home";
    }

    @RequestMapping("/articles")
    public String viewArticles() {
        return "articles";
    }

    @RequestMapping("/guestMsg")
    public String viewNotes() {
        return "guestmsg";
    }

    @RequestMapping("/article/{id}/detail")
    public String viewArticleDetail(@PathVariable("id") Integer id, HttpServletResponse response) {
        response.addCookie(new Cookie("article_id", id.toString()));
        return "article-detail";
    }
}
