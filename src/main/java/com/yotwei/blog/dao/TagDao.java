package com.yotwei.blog.dao;


import com.yotwei.blog.enity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by YotWei on 2018/6/28.
 */
public interface TagDao {

    List<Tag> getTagListByArticleId(@Param("articleId") int articleId);
}
