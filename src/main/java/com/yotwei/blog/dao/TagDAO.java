package com.yotwei.blog.dao;

import com.yotwei.blog.enity.Tag;

import java.util.List;
import java.util.Map;

/**
 * Created by YotWei on 2018/2/5.
 */
public interface TagDAO {

    List<Tag> getArticleTags(int articleId);

    List<Tag> getAllTags();

    int addTag(Tag tag);

    int deleteTag(int delId);

    Map<String,String> findRecordByTagId(int id);
}
