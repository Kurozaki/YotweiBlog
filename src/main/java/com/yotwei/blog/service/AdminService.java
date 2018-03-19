package com.yotwei.blog.service;

import com.yotwei.blog.dao.AdminDAO;
import com.yotwei.blog.dao.ArticleDAO;
import com.yotwei.blog.dao.TagDAO;
import com.yotwei.blog.enity.Admin;
import com.yotwei.blog.enity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by YotWei on 2018/3/12.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private TagDAO tagDAO;

    public boolean login(HttpServletRequest request, String account, String password) {
        Admin loginAdmin = adminDAO.loginQuery(account, password);
        if (loginAdmin == null)
            return false;
        request.getSession().setAttribute("admin", loginAdmin);
        return true;
    }

    public List<Map<String, String>> admGetArticleList(){
        return articleDAO.admGetArticleList();
    }

    public List<Tag> admGetTagList(){
        return tagDAO.getAllTags();
    }

    public Tag addTag(String name){
        Tag tag = new Tag();
        tag.setName(name);
        tagDAO.addTag(tag);
        return tag;
    }

    public int deleteTag(int delId){

        return tagDAO.deleteTag(delId);
    }
}
