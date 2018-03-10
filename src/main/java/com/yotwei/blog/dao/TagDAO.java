package com.yotwei.blog.dao;

import com.yotwei.blog.enity.Tag;

import java.util.List;

/**
 * Created by YotWei on 2018/2/5.
 */
public interface TagDAO {

    List<Tag> getArticleTags(int articleId);

    List<Tag> getAllTags();
}
