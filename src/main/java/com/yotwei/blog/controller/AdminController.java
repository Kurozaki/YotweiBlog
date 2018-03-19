package com.yotwei.blog.controller;

import com.yotwei.blog.dto.ResponseBean;
import com.yotwei.blog.enity.Tag;
import com.yotwei.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YotWei on 2018/3/12.
 */
@CrossOrigin("*")
@Controller
@ResponseBody
@RequestMapping(value = "/admin", produces = "text/json; charset=utf-8")
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private HttpServletRequest httpRequest;

    /**
     * 管理员登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("account") String account,
                        @RequestParam("password") String password) {
        return service.login(httpRequest, account, password) ?
                ResponseBean.success(null).toString() :
                ResponseBean.error("Error account or password").toString();
    }

    /**
     * 查看文章列表
     */
    @RequestMapping("/article/list")
    public String getArticleList() {
        return ResponseBean.success(service.admGetArticleList()).toString();
    }

    /**
     * 获取标签列表
     */
    @RequestMapping("/tag/list")
    public String getTagList() {
        return ResponseBean.success(service.admGetTagList()).toString();
    }

    /**
     * 添加一个标签
     */
    @RequestMapping("/tag/add")
    public String addTag(@RequestParam("tag_name") String tagName) {
        Tag tag = service.addTag(tagName);
        return tag == null ?
                ResponseBean.error("error").toString() :
                ResponseBean.success(tag).toString();
    }

    /**
     * 删除一个标签
     */
    @RequestMapping("/tag/delete")
    public String deleteTag(@RequestParam("del_id") int delId) {
        int flag = service.deleteTag(delId);
        return flag > 0 ?
                ResponseBean.success(null).toString() :
                ResponseBean.error("删除错误").toString();
    }
}
